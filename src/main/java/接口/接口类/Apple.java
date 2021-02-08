package 接口.接口类;

/**
 * @author zedd
 * @date 2021/2/2
 **/
public interface Apple {

    void eat();

    void pick();

    default void defaultVoid(){
        System.out.println("默认方法，无需实现即可调用");
    }
}
