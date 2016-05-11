/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	
	public Element getElementByClass(Document doc, String className){
		Element el = doc.getElementsByClass(className).first();
		return el;
	}
	
	public Element getElementByClass(Element el, String className){
		return el.getElementsByClass(className).first();
	}
	
	public Element getElementByTag(Element el, String tagName){
		return el.getElementsByTag(tagName).first();
	}

	public Elements getElementsByTag(Element el, String tagName){
		return el.getElementsByTag(tagName);
	}

	public Elements getElementsByTag(Document doc, String tagName){
		return doc.getElementsByTag(tagName);
	}
	
	

}
