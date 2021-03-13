package 流式编程;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author zedd
 * @date 2021/2/5
 * 创建流的方法
 **/
public class StreamOf {


    public static void main(String[] args) {
        //使用StreamOf创建流
        String[] arr1 = {"",""};
        String[] arr = new String[]{"this", "Stream of", "key", "words"};
        Stream.of(arr).forEach(System.out::println);

        //集合创建流
        Set<String> stringSet = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        stringSet.stream().map(x -> x + "").forEach(System.out::println);
        System.out.println("=================");

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);

        System.out.println("================");
        System.out.println(System.getProperty("os.name"));
    }
}
