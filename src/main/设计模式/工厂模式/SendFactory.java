package 工厂模式;

/**
 * @author zedd
 * @date 2021/2/3
 * 工厂类
 **/
public interface SendFactory {

    /**
     * 定义一个用于创建对象的接口，让子类绝对实例化哪一个类，工厂方法使一个类的实例化延迟到其子类。
     * */
    public Sender createSender();

}
