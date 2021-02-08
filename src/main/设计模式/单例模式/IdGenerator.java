package 单例模式;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zedd
 * @date 2021/2/2
 * id生成器
 **/
public class IdGenerator {

    /**
     * 1.恶汉式：初始化时创建好对象
     * 2.懒汉式：调用方法时再加载对象
     * */
    private AtomicLong id = new AtomicLong(0);

    //1.
    private static final IdGenerator instance = new IdGenerator();
    //2.
//    private static final IdGenerator instance;

    private IdGenerator() {
    }
    //1.初始化时加载
    private IdGenerator getInstanse() {
        return instance;
    }
    //2.初始化时加载
    /*private IdGenerator getInstanse() {
        return new IdGenerator();
    }*/

    Long addId() {
        return id.incrementAndGet();
    }
}
