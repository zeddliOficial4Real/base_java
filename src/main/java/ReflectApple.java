import java.lang.reflect.Method;

/**
 * @author zedd
 * @date 2021/2/25
 * 反射的应用
 **/
public class ReflectApple {

    /**
     * 反射就是在运行时才知道要操作的类是什么
     * 并且可以在运行时获取类的完整构造，并调用对应的方法。
     */

    int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        //正常创建对象
        ReflectApple apple = new ReflectApple();
        apple.setPrice(10);
        System.out.println(apple.getPrice());

        //反射
        try {
            //使用 Class.forName 静态方法
            //Class clazz = Class.forName("ReflectApple");
            //使用 .class 方法
            //这种方法只适合在编译前就知道操作的 Class
            Class<ReflectApple> clazz = ReflectApple.class;
            //1.使用构造方法创建新对象
            Object instance = clazz.getConstructor().newInstance();
            //2.通过Class对象的 newInstance() 方法创建对象
            //instance = clazz.newInstance();
            Method setMethod = clazz.getMethod("setPrice", int.class);
            //利用 invoke 方法调用方法
            setMethod.invoke(instance, 101);
            //get方法
            Method getMethod = clazz.getMethod("getPrice");
            System.out.println(getMethod.invoke(instance));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
