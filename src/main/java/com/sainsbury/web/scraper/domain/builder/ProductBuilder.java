/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import com.sainsbury.web.scraper.domain.Product;

/**
 * This class will build the Product with its details
 * 
 * @author ARaut
 *
 */
public class ProductBuilder implements Builder<Product> {

	
	
	/**
	 * constructor
	 */
	public ProductBuilder() {
		
	}

	/**
	 * This method will build product object with title, unit_price, size & description. 
	 * 
	 * @return product info
	 */
	public Product build(){
		Product product = new Product(); 
		return product;
	}
	
}
