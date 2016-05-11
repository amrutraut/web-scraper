/**
 * 
 */
package com.sainsbury.web.scraper.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.sainsbury.web.scraper.domain.ProductWebPage;

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
		return div.text();
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
		Element elUnitPrice = doc.getElementsByClass("pricePerUnit").first();
		String strUnitPrice = elUnitPrice.text();
		strUnitPrice = strUnitPrice.replaceAll("[^0-9.]+", "");
		double dbUnitPrice = Double.parseDouble(strUnitPrice);
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
	 * @return String web page size in kb
	 */
	public String getWebPageSizeInKB(){
		double pageSize = doc.html().length() /1024;
		return String.valueOf(pageSize) + "kb";
	}
	
	public List<ProductWebPage> getListOfProdcutLinks(){
		List<ProductWebPage> webPages = new ArrayList<ProductWebPage>();
		
		return null;
		
	}
}
