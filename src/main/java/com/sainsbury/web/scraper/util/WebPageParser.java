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
 * <p>
 * This class is wrapper to Jsoup lib & has helper methods to get the page info.
 * </p>
 * @author ARaut
 *
 */
public class WebPageParser {
	
	private Document doc;
	
	/**
	 * field constructor to build Jsoup document.
	 *  
	 * @param url to parse
	 * @throws IOException when not able to connect to given url
	 */
	public WebPageParser(String url) throws IOException{
		this.doc = Jsoup.connect(url).get();
	}
	
	/**
	 * This method  uses Jsoup document to get product tile on the page
	 * 
	 * @return String product title
	 */
	public String getProductTitle(){
		Element div = doc.getElementsByClass("productTitleDescriptionContainer").first();
//		Element title = div.getElementsByTag("h1").first();
		Element title = doc.getElementsByTag("h1").first();
		System.out.println("divText: " + div.text());
		System.out.println("titleText: " + title.text());
		
		return title.text();
	}
	
	/**
	 * This method  uses Jsoup document to get product description on the page
	 * 
	 * @return String product description
	 */
	public String getProductDescription(){
		Element desc = doc.getElementsByClass("productText").first();
		return desc.text();
	}
	
	/**
	 * This method  uses Jsoup document to get product unit price on the page
	 * 
	 * @return double product unit price
	 */
	public double getProdcutUnitPrice(){
		Element unitPrice = doc.getElementsByClass("pricePerUnit").first();
		double dbUnitPrice = Double.parseDouble(unitPrice.text());
		return dbUnitPrice;
	}
	
	/**
	 * This method  uses Jsoup document to get product size on the page
	 * 
	 * @return String product size
	 */
	public String getProductSize(){
		Element productSize = doc.getElementsByClass("productText").get(3);
		return productSize.text();
	}
	
	/**
	 * This method returns Jsoup document for webpage
	 * 
	 * @return Document webpage document
	 */
	public Document getWebPage() {
		return doc;
	}
	
	/**
	 * This method  uses Jsoup document to get web page size in kb
	 * 
	 * @return double web page size in kb
	 */
	public double getWebPageSizeInKB(){
		double pageSize = doc.html().length() /1024;
		return pageSize;
	}
	
}
