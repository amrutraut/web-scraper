/**
 * 
 */
package com.sainsbury.web.scraper.domain.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsbury.web.scraper.domain.Product;
import com.sainsbury.web.scraper.domain.ProductWebPage;

/**
 * Unit test for ProdcutBuilder
 * 
 * @author ARaut
 *
 */
public class ProductBuilderTest {
	
	private ProductBuilder builder;
	private ProductWebPage webPage;
	private Product expectedProduct;
	
	private static final String validURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		webPage = new ProductWebPage(validURL);
		builder = new ProductBuilder(webPage);
		expectedProduct = new Product("Sainsbury's Apricot Ripe & Ready x5", "34.0kb", 3.5, "Apricots");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		webPage = null;
		builder = null;
	}

	@Test
	public void buildsProdcut() {
		Product actualProduct = builder.build();
		assertNotNull(expectedProduct);
		assertEquals(expectedProduct.toString(), actualProduct.toString());
	}

}
