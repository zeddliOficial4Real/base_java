package 工厂模式;

/**
 * @author zedd
 * @date 2021/2/3
 * 工厂类
 **/
public class SendMesFactory implements SendFactory{

    @Override
    public Sender createSender() {
        return new SendMessage();
    }

    public static void main(String[] args) {
        SendFactory mes = new SendMesFactory();
        Sender send = mes.createSender();
        String s = send.send("用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。" + "\n" + "因为抽象 工厂不太好理解，我们先看看图，然后就和代码，就比较容易理解");
        System.out.println(s);
    }
}
