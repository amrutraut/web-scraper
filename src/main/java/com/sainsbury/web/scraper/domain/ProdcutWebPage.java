/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;
import java.util.List;

import com.sainsbury.web.scraper.util.WebPageParser;

/**
 * This class gets all the scraped product details on the page.
 * 
 * @author ARaut
 */
public class ProdcutWebPage {

	private WebPageParser parser;
			
	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 * @throws IOException 
	 */
	public ProdcutWebPage(String url) throws IOException {
		parser = new WebPageParser(url);
	}

	/**
	 * This method returns product tile on the page
	 * 
	 * @return String product title
	 */
	public String getProductTitle(){
		return parser.getProductTitle();
	}
	
	/**
	 * This method returns product description on the page
	 * 
	 * @return String product description
	 */
	public String getProductDescription(){
		return parser.getProductDescription();
	}
	
	/**
	 * This method returns product unit price on the page
	 * 
	 * @return double product unit price
	 */
	public double getProdcutUnitPrice(){
		return parser.getProdcutUnitPrice();
	}
	
	/**
	 * This method returns product size on the page
	 * 
	 * @return String product size
	 */
	public String getProductSize(){
		return parser.getProductSize();
	}
	
	/**
	 * This method returns web page size in kb
	 * 
	 * @return String web page size in kb
	 */
	public String getPageSize(){
		return parser.getWebPageSizeInKB();
	}
	
	public List<ProdcutWebPage> getListOfProdcutLinks(){
		
		return null;
		
	}

}
