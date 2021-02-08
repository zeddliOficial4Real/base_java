package 控制台jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author zedd
 * @date 2021.01
 **/
public class NovelJsoup {

    //229715
    //229783
    int count = 3798;
    //String url = "http://www.biquku.la/0/424/"+count+".html";
    //http://www.xbiquge.la/0/15/13344.html
    //http://www.bswtan.com/0/424/231942.html
//    https://www.doupobook.com/dazhuzai/3798.html

    public void getNovelText() throws IOException {
        String url = "http://www.doupobook.com/dazhuzai/" + count + ".html";
        long start = System.currentTimeMillis();
        //ignoreHttpErrors 忽略網頁http返回錯誤
        Document doc = Jsoup.connect(url).timeout(500000).ignoreContentType(true).ignoreHttpErrors(true).get();
//        Jsoup.connect("").
        if (null == doc.toString()) {
            count++;
            getNovelText();
        }
        Elements elements = doc.select("#content");
        String html = elements.html();
        if (html.contains("<br>&nbsp;&nbsp;&nbsp;&nbsp;") || html.contains("<br>") || html.contains("&nbsp;&nbsp;&nbsp;&nbsp;") || html.contains("www、biquku、la■")) {
            html = html.replace("<br>&nbsp;&nbsp;&nbsp;&nbsp;", "");
            html = html.replace("<br>", "");
        }
        GetHtmlTime.getTimeOut(start);
        System.out.println(html);
        count++;
        getNovelText();
    }

    public static void main(String[] args) throws IOException {
        NovelJsoup novelJsoup = new NovelJsoup();
        novelJsoup.getNovelText();
    }
}
