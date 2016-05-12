/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.ProductWebPage;
import com.sainsbury.web.scraper.domain.ScraperResult;

/**
 * This class builds the Scraper Result containing list of all the products.  
 * 
 * @author ARaut
 *
 */
public class ScraperResultBuilder implements Builder<ScraperResult> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScraperResultBuilder.class);

	private List<ProductWebPage> webPages;
	
	private double total;
	
	/**
	 * field constructor
	 * @param webPage web page info
	 */
	public ScraperResultBuilder(List<ProductWebPage> webPages){
		this.webPages = webPages;
	}
	
	/**
	 * <p>
	 * This method with build the ScraperResult for WebScraper having,
	 * list of products with their details & total.
	 * </p>
	 * @return result containing list of products with their details & total
	 */
	public ScraperResult build() {
		LOGGER.debug("Building Scraper Result for product list webpage");
		
		List<Product> prodcutList = new ArrayList<Product>();
		total = 0.0;
		
		// Build Product for each product webpage
		for (ProductWebPage webPage : webPages ){
			LOGGER.debug("Building product for webpage: {}", webPage.getProductTitle());
			
			Product product = new ProductBuilder(webPage).build();
			
			// add total for each products unit price
			total = total + product.getUnit_price();
			prodcutList.add(product);
		}
		
		// Setting scale with rounding mode for total.
		total = new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		ScraperResult results = new ScraperResult(prodcutList, total);
		
		LOGGER.debug("Scraper Result: {}", results.toString());
			
		return results;
	}

}
