package by.Isachenko.Lesson10.app;

import by.Isachenko.Lesson10.pages.CatalogPage;
import by.Isachenko.Lesson10.pages.MainPage;
import by.Isachenko.Lesson10.pages.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Application {
    private WebDriver driver;
    private WebDriverWait wait;

    private MainPage mainPage;
    private Menu menu;
    private CatalogPage catalogPage;

    By orderSummaru = By.cssSelector("#order_confirmation-wrapper");
    By iconDuckLocator = By.cssSelector(".shortcut a");
    By noProductMessage = By.cssSelector("em");

    public Application() {
        LoggingPreferences log = new LoggingPreferences();
        log.enable(LogType.BROWSER, Level.INFO);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, log);
        options.setExperimentalOption("w3c", false);
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mainPage = new MainPage(driver, wait);
        menu = new Menu(driver, wait);
        catalogPage = new CatalogPage(driver, wait);
    }

    public void quit() {
        driver.quit();
    }

    public void logAsAdmin(){
        mainPage.open();
        System.out.println("Info: " + "Loggin as admin.");
        mainPage.setName("admin").setPassword("admin").loginBtnClick();
    }

    public void selectFolder(String nameFolder){
        menu.menuClick(menu.catalogMenu);
        List<WebElement> list = catalogPage.getAllElements();
        for (int i =0; i<list.size(); i++){
            String name = catalogPage.getElementName(list.get(i));
            if (name.equals(nameFolder)){
                list.get(i).click();
                break;
            }
            list = catalogPage.getAllElements();
        }
    }

    public void checkSiteLog(){
        List<WebElement> list = catalogPage.getdAllproducts();
        for (int i =0; i<list.size(); i++){
            System.out.println("Info: Select element -- " + catalogPage.getElementName(list.get(i)));
            list.get(i).click();
            checkLog("browser");
            driver.navigate().back();
            list = catalogPage.getdAllproducts();
        }
    }

    public void checkLog(String name){
        List<LogEntry> l = driver.manage().logs().get(name).getAll();
        Boolean f = true;
        if (l.size()>0){
            for (LogEntry j :l) {
                if (j.toString().contains("SEVERE")){
                    System.out.println(j.getLevel());
                    f = false;
                }
            }
        }
        if (f){
            System.out.println("Info: There are no warnings in the log.");
        }
    }
}
