/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.ScraperResult;
import com.sainsbury.web.scraper.domain.ProdcutWebPage;

/**
 * Unit test for ScraperResultBuilder
 * 
 * @author ARaut
 *
 */
public class ScraperResultBuilderTest {
	
	private ScraperResultBuilder builder;
	
	private List<ProdcutWebPage> webPages;
	
	private ScraperResult expectedResult;
	
	private static final String apricotURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html";
	private static final String avocadoURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-avocado-xl-pinkerton-loose-300g.html";

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		webPages = new ArrayList<ProdcutWebPage>();
		webPages.add(new ProdcutWebPage(apricotURL));
		webPages.add(new ProdcutWebPage(avocadoURL));
		
		builder = new ScraperResultBuilder(webPages);
		
		expectedResult = buildExpectedResult();
	}
	
	private ScraperResult buildExpectedResult(){
		Product apricot = new Product("Sainsbury's Apricot Ripe & Ready x5", "34.0kb", 3.5, "Apricots");
		Product avocado = new Product("Sainsbury's Avocado Ripe & Ready XL Loose 300g", "35.0kb", 1.5, "Avocados");
		double total = 5.0;
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(apricot);
		productList.add(avocado);
		
		ScraperResult result = new ScraperResult(productList, total);
		return result;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void buildsScraperresult() {
		ScraperResult result = builder.build();
		assertNotNull(result);
		assertEquals(expectedResult.toString(), result.toString());
	}
	
	

}
