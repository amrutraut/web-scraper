/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import java.util.ArrayList;
import java.util.List;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.WebPage;

/**
 * @author ARaut
 *
 */
public class ScraperResultBuilder implements Builder<ScraperResult> {

	private List<WebPage> webPages;
	
	private List<Product> prodcutList;
	
	private double total;
	
	/**
	 * field constructor
	 * @param webPage web page info
	 */
	public ScraperResultBuilder(List<WebPage> webPages){
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
		
		ScraperResult results = new ScraperResult();

		prodcutList = new ArrayList<Product>();
		total = 0.0;
		
		for (WebPage webPage : webPages ){
			
			Product product = new ProductBuilder(webPage).build();
			total = total + product.getUnit_price();
			prodcutList.add(product);
		}
		
		results.setResult(prodcutList);
		results.setTotal(total);
			
		return results;
	}

}
