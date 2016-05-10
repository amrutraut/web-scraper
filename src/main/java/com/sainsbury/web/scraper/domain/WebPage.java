/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * This class holds all the web page details to be scraped.
 * 
 * @author ARaut
 */
public class WebPage {

	private String url;

	private Document doc;

	/**
	 * field constructor
	 * 
	 * @param url to be scraped
	 */
	public WebPage(String url) {
		this.url = url;
	}

	public Document getWebPage() throws IOException {
		Document doc = Jsoup.connect(url).get();
		return doc;
	}
	
	

}
