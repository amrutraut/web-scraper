/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import com.sainsbury.web.scraper.domain.ScraperResult;

/**
 * @author ARaut
 *
 */
public class ScraperResultBuilder implements Builder<ScraperResult> {

	
	public ScraperResultBuilder(){
		
	}
	
	/**
	 * <p>
	 * This method with build the ScraperResult for WebScraper having,
	 * list of products with their details & total.
	 * </p>
	 * @return result containing list of products with their details & total
	 */
	public ScraperResult build() {
		
		ScraperResult result = new ScraperResult();
			
		return result;
	}

}
