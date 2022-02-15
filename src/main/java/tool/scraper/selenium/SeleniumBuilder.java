package tool.scraper.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface SeleniumBuilder {

    WebDriver getDriver();

    void acessar(String url);

    void clicar(By by);

}
