package 工厂模式;

/**
 * @author zedd
 * @date 2021/2/3
 **/
public class SendMessage implements Sender{

    @Override
    public String send(String info) {
        System.out.println("获取信息....");
        System.out.println("输出信息....");
        return info;
    }
}
