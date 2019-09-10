package com.pinyou.config.redis.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @desc: 分布式锁模板
 **/
@Component
public class RedisLockTemplate implements DistributeLockTemplate {
    private final Logger log = LoggerFactory.getLogger(RedisLockTemplate.class);

    @Autowired
    private RedisReentrantLock redisReentrantLock;
    @Override
    public Object execute(String lockKey, int timeout, Callback callback) {
        boolean getLock = false;
        try {
            if (redisReentrantLock.tryLock(lockKey,timeout, TimeUnit.MILLISECONDS)){
                getLock = true;
                log.info("当前用户获取锁 "+Thread.currentThread().getName());
                return callback.onGetLock();
            }else {
                log.info("当前用户获取锁超时 "+Thread.currentThread().getName());
                return callback.onTimeout();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            log.error(ie.getMessage(),ie);
            Thread.currentThread().interrupt();
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }finally {
            if (getLock){
                redisReentrantLock.unLock();
                log.info("当前用户已解锁 "+Thread.currentThread().getName());
            }
        }
        return null;
    }
}
