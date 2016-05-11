/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;

import com.sainsbury.web.scraper.util.WebPageParser;

/**
 * This class holds all the web page details to be scraped.
 * 
 * @author ARaut
 */
public class WebPage {

	private WebPageParser parser;
			
	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 * @throws IOException 
	 */
	public WebPage(String url) throws IOException {
		parser = new WebPageParser(url);
	}

	public String getProductTitle(){
		return parser.getProductTitle();
	}
	
	public String getProductDescription(){
		return parser.getProductDescription();
	}
	
	public Double getProdcutUnitPrice(){
		return parser.getProdcutUnitPrice();
	}
	
	public String getProductSize(){
		return parser.getProductSize();
	}
	
	public String getPageSize(){
		return String.valueOf(parser.getWebPageSizeInKB());
	}

}
