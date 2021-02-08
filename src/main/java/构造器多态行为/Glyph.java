package 构造器多态行为;

/**
 * @author zedd
 * @date 2021/2/2
 * 基类
 **/
public class Glyph {

    void draw() {
        System.out.println("基类 Glyph.draw()");
    }

    Glyph() {
        System.out.println("1.Glyph() before draw()");
        draw();
        System.out.println("2.Glyph() after draw()");
    }
}
