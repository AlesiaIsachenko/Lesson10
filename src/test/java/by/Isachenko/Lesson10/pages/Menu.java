package by.Isachenko.Lesson10.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu extends Page {
    @FindBy(css="#app- [href*=countries]")
    public WebElement countriesMenu;

    @FindBy(css="#app- [href*=geo_zones]")
    public WebElement geoZonesMenu;

    @FindBy(css="#app- [href*=catalog]")
    public WebElement catalogMenu;

    public Menu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void menuClick(WebElement element){
        element.click();
        System.out.println("Info: " + "Menu (" + element.getAttribute("outerText") + ") -- click.");
    }
}
