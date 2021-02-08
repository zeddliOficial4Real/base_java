package 函数式编程.lambda表达式;

/**
 * @author zedd
 * @date 2021/2/3
 * lambda表达式demo
 **/
public class LambdaExpression {

    //1.无参方法的lambda
    static Description description = () -> "1.Description.void: zero param";
    //
    static Body body = h -> h + "2.Body.void: one param";
    static Body body1 = (h) -> h + "2.Body.void: one param";

    //3. multi param
    static Multi mult = (h, n) -> h + n; // [4]

    static Description moreLines = () -> {
        System.out.println("如果在 Lambda 表达式中确实需要多行，则必须将这些行放在花括号中。 " + "\n" + "在这种情况下，就需要使用 return");
        return "调用类路径：" + Multi.class.getCanonicalName();
    };

    public static void main(String[] args) {
        System.out.println(description.brief());
        System.out.println(body.oneParam("Oh!"));
        System.out.println(body1.oneParam("Hi!"));

        System.out.println(mult.tripleParam("Pi! ", "3.14159"));
        System.out.println(moreLines.brief());
    }
}
