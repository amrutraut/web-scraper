/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.WebPage;

/**
 * This class will build the Product with its details
 * 
 * @author ARaut
 *
 */
public class ProductBuilder implements Builder<Product> {

	private WebPage webPage;
	
	/**
	 * field constructor
	 * @param webPage web page info
	 */
	public ProductBuilder(WebPage webPage) {
		this.webPage = webPage;
	}

	/**
	 * This method will build product object with title, unit_price, size & description. 
	 * 
	 * @return product info
	 */
	public Product build(){
		Product product = new Product(webPage.getProductTitle(), webPage.getPageSize(), webPage.getProdcutUnitPrice(), webPage.getProductDescription()); 
		return product;
	}
	
}
