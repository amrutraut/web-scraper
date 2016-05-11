package com.sainsbury.web.scraper;

import java.io.IOException;
import java.util.List;

import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.ProductListWebPage;
import com.sainsbury.web.scraper.domain.ProductWebPage;
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
    	
    	ProductListWebPage webPage = new ProductListWebPage(url);
    	
    	List<ProductWebPage> webPages = webPage.getListOfProductPages();
    	
    	ScraperResultBuilder resultBuilder = new ScraperResultBuilder(webPages);

    	ScraperResult result = resultBuilder.build();
    	
    	return result;
    }
    
}
