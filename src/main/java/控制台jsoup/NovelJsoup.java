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
    int count = 6446764;
    //String url = "http://www.biquku.la/0/424/"+count+".html";
    //http://www.xbiquge.la/0/15/13344.html
    //http://www.bswtan.com/0/424/231942.html
//    http://www.paoshuzw.com/0/8/5728.html
    //http://www.paoshuzw.com/0/8/5043487.html
    //http://www.paoshuzw.com/0/8/6446764.html

    public void getNovelText() throws IOException {
        String url = "http://www.paoshuzw.com/0/8/" + count + ".html";
        long start = System.currentTimeMillis();
        //ignoreHttpErrors 忽略網頁http返回錯誤
        Document doc = Jsoup.connect(url).timeout(500000).ignoreContentType(true).ignoreHttpErrors(true).get();
//        Jsoup.connect("").
        if (null == doc.toString()) {
            count++;
            getNovelText();
        }
        Elements elements = doc.select("#content");
        Elements elements1 = doc.select("#wrapper > div.content_read > div > div.bookname > h1");
        String html = elements.html();
        html = elements1.html() + "\n\n" + html;
        if (html.contains("<br>&nbsp;&nbsp;&nbsp;&nbsp;") || html.contains("<br>") || html.contains("&nbsp;&nbsp;&nbsp;&nbsp;") || html.contains("www、biquku、la■")) {
            html = html.replace("<br>&nbsp;&nbsp;&nbsp;&nbsp;", "");
            html = html.replace("&nbsp;&nbsp;&nbsp;&nbsp;", "");
            html = html.replace("<br>", "");
            html = html.replace("<p><a href=\"http://koubei.baidu.com/s/paoshuzw.com\" target=\"_blank\">亲,点击进去,给个好评呗,分数越高更新越快,据说给新笔趣阁打满分的最后都找到了漂亮的老婆哦!</a>手机站全新改版升级地址：http://m.paoshuzw.com，数据和书签与电脑站同步，无广告清新阅读！</p>", "");
        }
//        System.out.println(GetHtmlTime.getTimeOut(start));

        System.out.println(html);
        count++;
        getNovelText();
    }

    public static void main(String[] args) throws IOException {
        NovelJsoup novelJsoup = new NovelJsoup();
        novelJsoup.getNovelText();
    }
}
