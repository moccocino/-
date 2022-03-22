package HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatingContactPersonTests {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://crm.geekbrains.space/");
    }

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }

    @Test
    void checkPanelProjects() throws InterruptedException {
        driver.get(BASE_URL);
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://crm.geekbrains.space/contact/");
        Thread.sleep(5000);
    }

    @Test
    void checkCreateProject() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/contact/");
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://crm.geekbrains.space/contact/create");
        Thread.sleep(5000);

    }
}