package 单例模式;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zedd
 * @date 2021/2/2
 * 单例模式的应用之一 --- 处理资源访问冲突
 **/
public class Logger {

    private FileWriter fileWritter;

    //私有构造方法
    private Logger() throws IOException {
        File file = new File("");
        fileWritter = new FileWriter(file, true);
    }

    private static Logger getInstance() throws IOException {
        return new Logger();
    }

    //处理日志方法，类级别锁，防止线程
    void log(String mes) throws IOException {
        //类级别的同步锁
        synchronized (Logger.class) {
            fileWritter.write(mes);
        }
    }

    public static void main(String[] args) throws IOException {
//        Logger logger = new Logger();
        Logger.getInstance().log("user login time:" + System.currentTimeMillis());
        // Logger类的应用示例：
        /**
         public class UserController {
         public void login(String username, String password) {
         // ...省略业务逻辑代码...
         Logger.getInstance().log(username + " logined!");
         }
         }
         public class OrderController {
         private Logger logger = new Logger();
         public void create(OrderVo order) {
         // ...省略业务逻辑代码...
         Logger.getInstance().log("Created a order: " + order.toString());
         }
         **/
    }
}
