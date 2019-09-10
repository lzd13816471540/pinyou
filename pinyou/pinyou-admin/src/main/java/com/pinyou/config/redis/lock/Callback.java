package com.pinyou.config.redis.lock;

/**
 * @desc: 回调函数
 **/
public interface Callback {

    public Object onGetLock() throws InterruptedException;

    public Object onTimeout() throws InterruptedException;
}
