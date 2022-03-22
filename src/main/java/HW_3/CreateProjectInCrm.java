package HW_3;

/*Задание: Создание проекта

Шаг 1
Авторизоваться на сайте CRM, используя следующие данные:
URL https://crm.geekbrains.space/; Логин/пароль: Applanatest1/Student2020!
Ожидаемый результат:
Пользователь успешно авторизовался, видит страницу «Панель инструментов».

Шаг 2
Перейти в «Проекты» → «Мои проекты»
Ожидаемый результат:
Пользователь находится на странице «Мои проекты», присутствует кнопка «Создать проект».

Шаг 3
Нажать на кнопку «Создать проект»
Ожидаемый результат:
Открыта страница создания проекта.

Шаг 4
Заполнить обязательные поля:
наименование;
организация;
основное контактное лицо;
подразделение;
куратор проекта;
руководитель проекта;
администратор проекта;
менеджер.
Ожидаемый результат:
Поля заполнены.

Шаг 5
Нажать на кнопку «Сохранить и закрыть»
Ожидаемый результат:
Страница создания проекта закрыта.
Пользователь видит страницу «Все проекты» и всплывающее уведомление о том,
что проект успешно создан.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateProjectInCrm {
    private static WebDriver driver;

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Самая лучшая организация в мире!");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> allOrganizations = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        allOrganizations.get(1).click();

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorUnitSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select rpUnutSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpUnutSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select administratorUnitSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select managerUnitSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerUnitSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain-uid')]/a")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");
        List<WebElement> allContactPersons = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        allContactPersons.get(1).click();

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
    }
}

