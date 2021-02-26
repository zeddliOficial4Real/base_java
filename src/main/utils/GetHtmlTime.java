/**
 * @author zedd
 * @date 2021/1/21
 * 网页响应时间
 **/
public class GetHtmlTime {

    public static String getTimeOut(Long stat){
//        long s=System.currentTimeMillis();
        long cost = System.currentTimeMillis() - stat;
        String s = String.valueOf(cost);
        System.out.println("网页响应时间："+s+"ms");
        return s;
    }

    public static String StringGetTime(){
        return null;
    }
}
