package 构造器多态行为;

/**
 * @author zedd
 * @date 2021/2/2
 * 派生类
 **/
public class RoundGlyph extends Glyph {
    /**
     * 1.在所有事发生前，分配给对象的存储空间会被初始化为二进制 0。
     * 2.如前所述调用基类构造器。此时调用重写后的 draw() 方法（是的，在调用 RoundGraph 构造器之前调用），由步骤 1 可知，radius 的值为 0。
     * 3.按声明顺序初始化成员。
     * 4.最终调用派生类的构造器。
     */
//    private static int radius = 1;
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("3.RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    private static RoundGlyph getInstance() {
        return new RoundGlyph(5);
    }

    @Override
    void draw() {
        System.out.println("4.派生类 RoundGlyph.draw(), radius = " + radius);
    }


    public static void main(String[] args) {

//        new RoundGlyph(5);
        RoundGlyph.getInstance().draw();
    }
}
