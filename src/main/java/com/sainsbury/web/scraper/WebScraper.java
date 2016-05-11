package com.sainsbury.web.scraper;

import java.io.IOException;

import org.jsoup.nodes.Document;

import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.WebPage;
import com.sainsbury.web.scraper.domain.builder.ScraperResultBuilder;

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

    public ScraperResult scrape(String url) throws IOException{
    	
    	WebPage webPage = new WebPage(url);
    	
    	ScraperResult result = new ScraperResult();
    	
    	
    	return result;
    }
    
}
