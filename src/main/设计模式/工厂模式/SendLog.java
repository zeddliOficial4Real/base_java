package 工厂模式;

/**
 * @author zedd
 * @date 2021/2/3
 **/
public class SendLog implements Sender {


    @Override
    public String send(String info) {
        System.out.println("获取日志信息....");
        System.out.println("输出日志信息....");
        return info;
    }
}
