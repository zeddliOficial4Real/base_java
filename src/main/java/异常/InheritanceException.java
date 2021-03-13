package 异常;

/**
 * @author zedd
 * @date 2021/2/23
 * 自定义异常
 * 异常的处理
 **/
public class InheritanceException {

    public void catchExcepion() throws SimpleException {
        System.out.println("throw SimpleException");
        throw new SimpleException();
    }

    public static void main(String[] args) throws SimpleException {
        InheritanceException sp = new InheritanceException();
        //try catch捕获异常
        try {
            sp.catchExcepion();
        } catch (SimpleException e) {
            e.printStackTrace();
        }
    }
}
