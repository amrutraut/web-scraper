package com.sainsbury.web.scraper;

import java.io.IOException;
import java.util.List;

import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.ProdcutListWebPage;
import com.sainsbury.web.scraper.domain.ProdcutWebPage;
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
    	
    	ProdcutListWebPage webPage = new ProdcutListWebPage(url);
    	
    	List<ProdcutWebPage> webPages = webPage.getListOfProdcutLinks();
    	
    	ScraperResultBuilder resultBuilder = new ScraperResultBuilder(webPages);

    	ScraperResult result = resultBuilder.build();
    	
    	return result;
    }
    
}
