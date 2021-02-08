package 方法重载;

/**
 * @author zedd
 * @date 2021/2/1
 * 父类方法
 **/
public class SuperClass {

    String getLetter(String s){
        System.out.println("SuperClass.getLetter(String)");
        return s;
    }

    char getLetter(char s){
        System.out.println("SuperClass.getLetter(char)");
        return s;
    }

    int getLetter(int s){
        System.out.println("SuperClass.getLetter(int)");
        return 0;
    }
}
