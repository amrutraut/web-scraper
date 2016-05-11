/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.util.List;

/**
 * This class contains list of all the products scraped & total of all the products.
 * 
 * @author ARaut
 *
 */
public class ScraperResult {

	private List<Product> results;
	
	private double total;
	
	/**
	 * field constructor
	 * 
	 * @param results list of products scraped
	 * @param total total of al the products
	 */
	public ScraperResult(List<Product> results, double total) {
		this.results = results;
		this.total = total;
	}

	public List<Product> getResults() {
		return results;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "ScraperResult [results=" + results + ", total=" + total + "]";
	}
	
	
}
