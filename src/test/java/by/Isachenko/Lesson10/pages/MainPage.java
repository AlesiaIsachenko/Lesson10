package by.Isachenko.Lesson10.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends Page{

    @FindBy(css="[name=username]")
    public WebElement userNameEl;

    @FindBy(name="password")
    public WebElement passwordEl;

    @FindBy(name="login")
    public WebElement loginBtn;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        return this;
    }

    public MainPage setName(String name) {
        userNameEl.sendKeys(name);
        return this;
    }
    public MainPage setPassword(String password) {
        passwordEl.sendKeys(password);
        return this;
    }

    public void loginBtnClick(){
        loginBtn.click();
    }
}
