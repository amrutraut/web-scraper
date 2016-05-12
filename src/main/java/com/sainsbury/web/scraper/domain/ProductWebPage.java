/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsbury.web.scraper.util.WebPageParser;

/**
 * This class gets all the scraped product details on the page.
 * 
 * @author ARaut
 */
public class ProductWebPage {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductWebPage.class);

	protected WebPageParser parser;
			
	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 * @throws IOException 
	 */
	public ProductWebPage(String url) throws IOException {
		parser = new WebPageParser(url);
	}

	/**
	 * This method returns product tile on the page
	 * 
	 * @return String product title
	 */
	public String getProductTitle(){
		LOGGER.debug("Getting prodcut tilte");
		return parser.getProductTitle();
	}
	
	/**
	 * This method returns product description on the page
	 * 
	 * @return String product description
	 */
	public String getProductDescription(){
		LOGGER.debug("Getting prodcut description");
		return parser.getProductDescription();
	}
	
	/**
	 * This method returns product unit price on the page
	 * 
	 * @return double product unit price
	 */
	public double getProdcutUnitPrice(){
		LOGGER.debug("Getting prodcut unit price");
		return parser.getProdcutUnitPrice();
	}
	
	/**
	 * This method returns product size on the page
	 * 
	 * @return String product size
	 */
	public String getProductSize(){
		LOGGER.debug("Getting prodcut size");
		return parser.getProductSize();
	}
	
	/**
	 * This method returns web page size in kb
	 * 
	 * @return String web page size in kb
	 */
	public String getPageSize(){
		LOGGER.debug("Getting page size");
		return parser.getWebPageSizeInKB();
	}

}
