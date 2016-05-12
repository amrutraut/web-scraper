package com.sainsbury.web.scraper;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sainsbury.web.scraper.domain.ProductListWebPage;
import com.sainsbury.web.scraper.domain.ProductWebPage;
import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.builder.ScraperResultBuilder;

/**
 * <P> 
 * This class scrapes  web pages using Jsoup lib. It will in essence use the URL passed to it & fetch that HTML into a Jsoup  
 * Document. Once it has Jsoup document, it will scrape through all the product links & return the json array 
 * containing product info in response.
 *</p>
 * @author ARaut
 */
public abstract class WebScraper 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(WebScraper.class);

    public static String scrape(String url) throws IOException {
    	LOGGER.debug("Inside web scraper");
    	
    	// using gson to create json output from Scraper Result
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonString = gson.toJson(getScraperResult(url));
    	
    	LOGGER.debug("finished scraping");
    	return jsonString;
    }
    
    private static ScraperResult getScraperResult(String url) throws IOException{
    	
    	LOGGER.debug("Getting Scrape Results");
    	
    	ProductListWebPage webPage = new ProductListWebPage(url);
    	
    	List<ProductWebPage> webPages = webPage.getListOfProductPages();
    	
    	ScraperResultBuilder resultBuilder = new ScraperResultBuilder(webPages);

    	ScraperResult result = resultBuilder.build();
    	
    	LOGGER.debug("Received scraper result");
    	
    	return result;
    }
    
}
