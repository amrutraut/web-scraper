/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.ProductWebPage;

/**
 * This class will build the Product with its details
 * 
 * @author ARaut
 *
 */
public class ProductBuilder implements Builder<Product> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBuilder.class);

	private ProductWebPage webPage;
	
	/**
	 * field constructor
	 * @param webPage web page info
	 */
	public ProductBuilder(ProductWebPage webPage) {
		this.webPage = webPage;
	}

	/**
	 * This method will build product object with title, unit_price, size & description. 
	 * 
	 * @return product info
	 */
	public Product build(){
		Product product = new Product(webPage.getProductTitle(), webPage.getPageSize(), webPage.getProdcutUnitPrice(), webPage.getProductDescription()); 
		LOGGER.debug("Product Info: {}", product.toString());
		return product;
	}
	
}
