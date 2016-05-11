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
	
	/**
	 * field constructor
	 * 
	 * @param title of the product
	 * @param size of the product page
	 * @param unit_price of the product
	 * @param description of the product
	 */
	public Product(String title, String size, double unit_price, String description) {
		this.title = title;
		this.size = size;
		this.unit_price = unit_price;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getSize() {
		return size;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", size=" + size + ", unit_price=" + unit_price + ", description="
				+ description + "]";
	}

	
}
