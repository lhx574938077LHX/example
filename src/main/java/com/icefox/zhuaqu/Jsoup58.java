package com.icefox.zhuaqu;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup58 {
	
	public static void main(String[] args) throws IOException {
//		getDataPages();
		test1();
	}
	
	public static void getDataPages() throws IOException{
        Document doc;
		doc = Jsoup.connect("http://bj.58.com/chuzu/pn1/?PGTID=0d3090a7-0000-16f8-92d5-0deb5c69cc84&ClickID=1").get();
        Elements ListDiv = doc.getElementsByAttributeValue("class","img_list");
        for (Element element : ListDiv) {
            Elements links = element.getElementsByTag("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text().trim();
//                System.out.println(linkHref);
//                System.out.println(linkText);
                getNameAndPhone(linkHref);
            }
        }
	}
	
	
	public static void getNameAndPhone(String url) {
		
        try {
        	Document docLow = Jsoup.connect(url).get();
            Elements ListNames = docLow.getElementsByAttributeValue("class", "c_000");
        	Elements ListPhones = docLow.getElementsByAttributeValue("class", "f36 lh75");
        	Elements titles = docLow.getElementsByTag("h1");
        	
            
        	if(ListPhones.size()==0){
           	 	Elements phonenums = docLow.getElementsByAttributeValue("class", "phonenum");
           	 	Elements titleH2s = docLow.getElementsByTag("h2");
	            for(Element titleH2:titleH2s){
	            	System.out.print(titleH2.html()+":");
	            }
	            for (Element phone : phonenums) {
	            	System.out.println(phone.html());
	            }
            }else{
            	for(Element title:titles){
            		System.out.println(title.text());
            	}
            	for(Element name:ListNames){
                	System.out.print(name.text()+":");
                }
            	
	            for (Element phone : ListPhones) {
	            	System.out.println(phone.text());
	            }
            }
		} catch (Exception e) {System.out.println("没有姓名或电话");}
        finally{
        	System.out.println();
        }
	}
	
	private static void test1(){
		try {
        	Document doc = Jsoup.connect("http://bj.58.com/hezu/24422308603315x.shtml?version=&psid=193600040193994831808059267&entinfo=24422308603315_0&iuType=p_0&PGTID=0d3090a7-0000-1fee-cc10-6f34efa9fa59&ClickID=12").get();
            Elements ListNames = doc.getElementsByAttributeValue("class", "c_000");
        	Elements ListPhones = doc.getElementsByAttributeValue("class", "f36 lh75");
        	Elements titles = doc.getElementsByTag("h1");
        	for(Element title:titles){
        		System.out.println(title.text());
        	}
        	for(Element name:ListNames){
            	System.out.print(name.text()+":");
            }
        	
            for (Element phone : ListPhones) {
            	System.out.println(phone.text());
            }
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void test(){
        try {
        	Document doc = Jsoup.connect("http://bj.58.com/hezu/22099474888203x.shtml?version=&psid=193600040193994831808059267&entinfo=22099474888203_0&iuType=p_0&PGTID=0d3090a7-0000-1fee-cc10-6f34efa9fa59&ClickID=13").get();
            Elements ListNames = doc.getElementsByAttributeValue("class", "c_000");
        	System.out.println(ListNames.size());
        	
        	Elements phonenums = doc.getElementsByAttributeValue("class", "phonenum");
       	 	Elements titleH2s = doc.getElementsByTag("h2");
            for(Element titleH2:titleH2s){
            	System.out.print(titleH2.html()+" : ");
            }
            for (Element phone : phonenums) {
            	System.out.println(phone.html());
            }
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
