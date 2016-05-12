/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class gets all the product to be scraped on the page.
 * 
 * @author ARaut
 */
public class ProductListWebPage extends ProductWebPage{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductListWebPage.class);
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
		LOGGER.debug("Getting list of products");
		return parser.getListOfProductPages();
	}

}
