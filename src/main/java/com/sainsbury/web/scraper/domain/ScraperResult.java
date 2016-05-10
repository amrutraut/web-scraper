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

	private List<Product> result;
	
	private double total;

	public List<Product> getResult() {
		return result;
	}

	public void setResult(List<Product> result) {
		this.result = result;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
