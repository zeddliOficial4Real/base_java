package 函数式编程.斐波那契数列;

/**
 * @author zedd
 * @date 2021/2/3
 * 斐波那契数列 - 函数式实现
 **/
public class RecursiveFibonacci {

    private IntCall fib;

    //递归
    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++)
            System.out.println(rf.fibonacci(i));
    }

}
