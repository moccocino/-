package HW_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWievCrm {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseWievCrm(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}