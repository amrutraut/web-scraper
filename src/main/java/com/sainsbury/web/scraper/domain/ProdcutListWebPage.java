/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;
import java.util.List;

import com.sainsbury.web.scraper.util.WebPageParser;

/**
 * This class gets all the product to be scraped on the page.
 * 
 * @author ARaut
 */
public class ProdcutListWebPage extends ProdcutWebPage{

	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 * @throws IOException 
	 */
	public ProdcutListWebPage(String url) throws IOException {
		super(url);
	}
	
	public List<ProdcutWebPage> getListOfProdcutLinks(){
		
		return null;
		
	}

}
