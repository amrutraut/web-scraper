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
public class ProductListWebPage extends ProductWebPage{

	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 * @throws IOException 
	 */
	public ProductListWebPage(String url) throws IOException {
		super(url);
	}
	
	/**
	 * This method returns list of product pages
	 * @return
	 * @throws IOException
	 */
	public List<ProductWebPage> getListOfProductPages() throws IOException{
		return parser.getListOfProductPages();
	}

}
