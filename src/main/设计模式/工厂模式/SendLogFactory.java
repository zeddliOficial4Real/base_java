package 工厂模式;

/**
 * @author zedd
 * @date 2021/2/3
 * 工厂类
 **/
public class SendLogFactory implements SendFactory{

    @Override
    public Sender createSender() {
        return new SendLog();
    }
}
