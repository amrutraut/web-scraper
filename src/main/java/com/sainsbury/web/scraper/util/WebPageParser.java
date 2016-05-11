/**
 * 
 */
package com.sainsbury.web.scraper.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author ARaut
 *
 */
public class WebPageParser {
	
	public Document doc;
	
	public WebPageParser(Document doc){
		this.doc =doc;
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
