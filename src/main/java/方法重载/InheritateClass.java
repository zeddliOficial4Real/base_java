package 方法重载;

/**
 * @author zedd
 * @date 2021/2/1
 * 子类可以重载父类方法
 **/
public class InheritateClass extends SuperClass{

    String getLetter(String s){
        System.out.println("InheritateClass: "+s);
        return s;
    }
    char getLetter(char s){
        System.out.println("InheritateClass: "+s);
        return s;
    }

    public static void main(String[] args) {
        SuperClass in = new InheritateClass();
        in.getLetter(1);
        in.getLetter("char");
    }
}
