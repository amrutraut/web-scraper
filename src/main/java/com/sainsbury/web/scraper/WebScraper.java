package com.sainsbury.web.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * <P> 
 * This class scrapes  web pages using Jsoup lib. It will in essence use the URL passed to it & fetch that HTML into a Jsoup  
 * Document. Once it has Jsoup document, it will scrape through all the product links & return the json array 
 * containing product info in response.
 *</p>
 * @author ARaut
 */
public class WebScraper 
{

    public Document scrape(String url) throws IOException{
    	
    	Document doc = Jsoup.connect(url).get();
    	
    	return doc;
    }
    
}
