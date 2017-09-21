package com.icefox.zhuaqu;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest1 {
	static String url="http://www.91zhengxin.com/";
	
	public static void main(String[] args) throws Exception {
		bolgBody();
//		article();
//		blog();
	}
    /**
     * 获取指定HTML 文档指定的body
     * @throws IOException
     */
    private static void bolgBody() throws IOException {
         
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
//        System.out.println(doc.body());
         
         
        // 从 URL 直接加载 HTML 文档
        Document doc2 = Jsoup.connect("http://bj.58.com/chuzu/?PGTID=0d100000-0000-191d-adcb-9ea952f6115b&ClickID=1").get();
        String title = doc2.body().toString();
        System.out.println(title);
    }
    
    /**
     * 获取网页中超链接的标题和链接
     */
    public static void article() {
        Document doc;
        try {
            doc = Jsoup.connect("http://www.91zhengxin.com/").get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","title");
            for (Element element : ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim();
                    System.out.println(linkHref);
                    System.out.println(linkText);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    /**
     * 获取指定博客文章的内容
     */
    public static void blog() {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","col-lg-4 col-md-4 col-sm-3");
            for (Element element :ListDiv) {
                System.out.println(element.html());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
}
