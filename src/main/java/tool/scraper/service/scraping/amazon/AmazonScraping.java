package tool.scraper.service.scraping.amazon;

import org.springframework.stereotype.Service;
import tool.scraper.selenium.ChromeDriverBuilder;
import tool.scraper.selenium.SeleniumBuilder;

@Service
public class AmazonScraping {

    private static final String URL = "https://www.amazon.com/Best-Sellers/zgbs";
    public static void main (String[]args){
        final SeleniumBuilder builder = new ChromeDriverBuilder();
        builder.acessar(URL);
    }

}
