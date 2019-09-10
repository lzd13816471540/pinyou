package com.pinyou.config.redis.lock;

/**
 * @desc: redis分布式锁模板
 **/
public interface DistributeLockTemplate {

    /**
     *
     * @param lockKey 业务Id
     * @param timeout 过期时间
     * @param callback 回调函数
     * @return
     */
    Object execute(String lockKey, int timeout, Callback callback);
}
