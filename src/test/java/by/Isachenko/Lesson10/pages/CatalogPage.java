package by.Isachenko.Lesson10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CatalogPage extends Page {
    By allElementsList = By.cssSelector(".row [href*='catalog&category'");
    By allProductsList = By.cssSelector("[href*='product&category']:not([title])");

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllElements(){
        return driver.findElements(allElementsList);
    }

    public List<WebElement> getdAllproducts(){
        return driver.findElements(allProductsList);
    }

    public String getElementName(WebElement element){
        return element.getAttribute("textContent");
    }
}
