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

	public List<Product> getResults() {
		return results;
	}

	public void setResult(List<Product> results) {
		this.results = results;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
