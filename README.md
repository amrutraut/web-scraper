Web-Scraper Application -

This is console application that scrapes the Sainsbury’s grocery site - Ripe Fruits page and returns a JSON array of all the
products on the page.

Dependencies - 
- Jsoup 1.9.1
- Json-Schema-Validator 2.2.3
- Gson 2.6.2
- commons-io 2.4
- log4j-slf4j-impl 2.4.1
- log4j-core 2.4.1
- junit 4.11


Package Structure -
- src/main/java - All application classes.
  - src/main/java/com/sainsbury/web/scraper - WebScraper class, 
  - src/main/java/com/sainsbury/web/scraper/domain - All the application domain classes.
  - src/main/java/com/sainsbury/web/scraper/domain/builder - Builder classes to build domain.
  - src/main/java/com/sainsbury/web/scraper/main - Main class, which starts the scraping project.
  - src/main/java/com/sainsbury/web/scraper/parser - Parser for parsing webpage using Jsoup. 

- src/main/resources - All resources used in main application.

- src/test/java - All test classes
  - src/test/java/com/sainsbury/web/scraper - Test for webScraper class, 
  - src/test/java/com/sainsbury/web/scraper/domain/builder - Test for builder classes.
  - src/test/java/com/sainsbury/web/scraper/parser - Test for Parser. 

- src/test/resources - All resources used in tests.

Building Local Copy -

Get the local copy of the project using below command -
- git clone git@github.com:amrutraut/webscraper.git

To build the app locally, use the below maven goal under /web-scraper -
- mvn -U package

Running Tests -

To run all the test run the following maven goal under /web-scraper - 
mvn -U test

Running App -

To run the app, use the following command on base directory of the project i.e. web-scraper -
java -jar target/web-scraper-0.0.1-SNAPSHOT.jar

The project has assembly plugin, which builds application jar with all the dependencies. You can copy this from /target folder to your desired location & run below command -
java -jar web-scraper-0.0.1-SNAPSHOT-jar-with-dependencies.jar 

There is also an option to provide url to be scraped from command line. Run the run the following command replacing the <url>

From /target folder -
java -jar target/web-scraper-0.0.1-SNAPSHOT.jar <url>

With jar having all the dependencies -
java -jar web-scraper-0.0.1-SNAPSHOT-jar-with-dependencies.jar <url>


