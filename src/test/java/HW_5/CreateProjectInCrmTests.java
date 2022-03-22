package HW_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class CreateProjectInCrmTests {

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
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://crm.geekbrains.space/project/my");
        Thread.sleep(5000);
    }

    @Test
    void checkCreateProject() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/my");
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://crm.geekbrains.space/project/create/");
        Thread.sleep(5000);
    }

    @Test
    void checkOrganizationName() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        Actions actions = new Actions(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Самая лучшая организация в мире!");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> allOrganizations = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        allOrganizations.get(1).click();

        Assertions.assertEquals("1234", allOrganizations.get(1));
        Thread.sleep(5000);

        assertThat(allOrganizations.get(1), hasText("1234"));
    }
}