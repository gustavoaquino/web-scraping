package tool.scraper.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBuilder implements SeleniumBuilder {

    private WebDriver driver;

    public ChromeDriverBuilder() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/GuuAq/Desktop/selenium/chromedriver.exe");
            this.driver = new ChromeDriver();
        }catch (Exception ex){
            this.driver.quit();
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void acessar(String url) {
        this.driver.get(url);
    }

    @Override
    public void clicar(By by) {
        this.driver.findElement(by);
    }
}
