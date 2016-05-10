/**
 * 
 */
package com.sainsbury.web.scraper.domain;

/**
 * This class contains the product info - title, size, unit_price, description 
 * 
 * @author ARaut
 *
 */
public class Product {

	private String title;
	
	private String size;
	
	private double unit_price;
	
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
