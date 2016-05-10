/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.WebPage;

/**
 * @author ARaut
 *
 */
public class ScraperResultBuilder implements Builder<ScraperResult> {

	private WebPage webPage;
	
	/**
	 * field constructor
	 * @param webPage web page info
	 */
	public ScraperResultBuilder(WebPage webPage){
		this.webPage = webPage;
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
