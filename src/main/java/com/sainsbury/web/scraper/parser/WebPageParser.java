/**
 * 
 */
package com.sainsbury.web.scraper.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsbury.web.scraper.domain.ProductWebPage;

/**
 * <p>
 * This class is wrapper to Jsoup lib & has helper methods to get the page info.
 * </p>
 * @author ARaut
 *
 */
public class WebPageParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebPageParser.class);
	
	private static final String productTitleClass = "productTitleDescriptionContainer";
	
	private static final String productDescriptionClass = "productText";
	
	private static final String productSizeClass = "productText";
	
	private static final String productUnitPriceClass = "pricePerUnit";
	
	private static int productUnitPriceIndex = 3;
	
	private static final String productListClass = "productInfo";
	
	private static final String productLinkTag = "a";
	
	private static final String productLinkAttribute = "href";
	
	private static final String extractUnitPriceRegEx = "[^0-9.]+";
	
	private Document doc;
	
	/**
	 * field constructor to build Jsoup document.
	 *  
	 * @param url to parse
	 * @throws IOException when not able to connect to given url
	 */
	public WebPageParser(String url) throws IOException{
		// use Jsoup to get web page for the url
		this.doc = Jsoup.connect(url).get();
	}
	
	/**
	 * This method  uses Jsoup document to get product tile on the page
	 * 
	 * @return String product title
	 */
	public String getProductTitle(){
		Element div = doc.getElementsByClass(productTitleClass).first();
		LOGGER.debug("Product Title: {}", div.text());
		return div.text();
	}
	
	/**
	 * This method  uses Jsoup document to get product description on the page
	 * 
	 * @return String product description
	 */
	public String getProductDescription(){
		Element desc = doc.getElementsByClass(productDescriptionClass).first();
		LOGGER.debug("Product Description: {}", desc.text());
		return desc.text();
	}
	
	/**
	 * This method  uses Jsoup document to get product unit price on the page
	 * 
	 * @return double product unit price
	 */
	public double getProdcutUnitPrice(){
		Element elUnitPrice = doc.getElementsByClass(productUnitPriceClass).first();

		// get the unit price as string 
		String strUnitPrice = elUnitPrice.text();
		LOGGER.debug("Product UnitPrice before extracting non-digits: {}", strUnitPrice);
		
		// replace all the non-digits from unit price
		strUnitPrice = strUnitPrice.replaceAll(extractUnitPriceRegEx, "");
		
		// convert unit price to double
		double dbUnitPrice = Double.parseDouble(strUnitPrice);
		LOGGER.debug("Product UnitPrice: {}", dbUnitPrice);
		
		return dbUnitPrice;
	}
	
	/**
	 * This method  uses Jsoup document to get product size on the page
	 * 
	 * @return String product size
	 */
	public String getProductSize(){
		Element productSize = doc.getElementsByClass(productSizeClass).get(productUnitPriceIndex);
		LOGGER.debug("Product Size: {}", productSize.text());
		return productSize.text();
	}
	
	/**
	 * This method returns Jsoup document for webpage
	 * 
	 * @return Document webpage document
	 */
	public Document getWebPage() {
		return doc;
	}
	
	/**
	 * This method  uses Jsoup document to get web page size in kb
	 * 
	 * @return String web page size in kb
	 */
	public String getWebPageSizeInKB(){
		// get document length as html to calculate size in kb
		double pageSize = doc.html().length() /1024;
		
		// append kb to page size
		String strPageSize = String.valueOf(pageSize) + "kb";
		LOGGER.debug("Page Size In KB:  {}", strPageSize);
		
		return strPageSize;
	}
	
	/**
	 * This method uses Jsoup to get all the prodcut pages on the Prodcut List page
	 * 
	 * @return List<ProductWebPage> list of all the product web pages. 
	 * @throws IOException
	 */
	public List<ProductWebPage> getListOfProductPages() throws IOException{
		List<ProductWebPage> webPages = new ArrayList<ProductWebPage>();
		
		LOGGER.debug("Getting the list of prodcut web page");
		
		// get all the product listed on the page 
		Elements productList = doc.getElementsByClass(productListClass);
		
		// get the product page for each link in the product list
		for (Element product : productList){
			// get the product page link tag
			Element anchor = product.getElementsByTag(productLinkTag).first();

			// get the product link
			String url = anchor.attr(productLinkAttribute);
			
			LOGGER.debug("Getting the prodcut web page for link: {}", url);
			// get the product web page for the link
			ProductWebPage webPage = new ProductWebPage(url);
			webPages.add(webPage);
		}
		
		return webPages;
	}
}
