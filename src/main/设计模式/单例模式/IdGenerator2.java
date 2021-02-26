package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zedd
 * @date 2021/2/2
 * 单例的实现方式2
 **/
public class IdGenerator2 {
    /**
     * 3.双重检测
     * 4.静态内部类：有点类似饿汉式，但又能做到了延迟加载
     * 5.枚举
     */
    //3 双重检测
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;

    private IdGenerator2() {
    }

    public static IdGenerator2 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new IdGenerator2();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    //4
    /*private static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }
    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
        */

    //5
   /* public enum IdGenerator {
        INSTANCE;
        private AtomicLong id = new AtomicLong(0);
        public long getId() {
            return id.incrementAndGet();
        }
    }*/
}
