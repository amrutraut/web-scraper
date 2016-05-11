/**
 * 
 */
package com.sainsbury.web.scraper.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author ARaut
 *
 */
public class WebPageParser {
	
	private Document doc;
	
	public WebPageParser(String url) throws IOException{
		this.doc = Jsoup.connect(url).get();
	}
	
	public String getProductTitle(){
		Element div = doc.getElementsByClass("productTitleDescriptionContainer").first();
//		Element title = div.getElementsByTag("h1").first();
		Element title = doc.getElementsByTag("h1").first();
		System.out.println("divText: " + div.text());
		System.out.println("titleText: " + title.text());
		
		return title.text();
	}
	
	public String getProductDescription(){
		Element desc = doc.getElementsByClass("productText").first();
		return desc.text();
	}
	
	public Double getProdcutUnitPrice(){
		Element unitPrice = doc.getElementsByClass("pricePerUnit").first();
		double dbUnitPrice = Double.parseDouble(unitPrice.text());
		return dbUnitPrice;
	}
	
	public String getProductSize(){
		Element productSize = doc.getElementsByClass("productText").get(3);
		return productSize.text();
	}
	
	public Document getWebPage() {
		return doc;
	}
	
	public double getWebPageSizeInKB(){
		double pageSize = doc.html().length() /1024;
		return pageSize;
	}
	
}
