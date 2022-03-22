package HW_3;

/*
Задание: Создание контактного лица в организации с минимально заполненной информацией.

Шаг 1
Авторизоваться на сайте CRM, используя следующие данные:
URL https://crm.geekbrains.space/; Логин/пароль: Applanatest1/Student2020!
Ожидаемый результат:
Пользователь успешно авторизовался, видит страницу «Панель инструментов».

Шаг 2
Перейти в «Контрагенты» → «Контактные лица»
Ожидаемый результат:
Пользователь находится на странице «Контактные лица»,
видит таблицу имеющихся контактных лиц, есть кнопка «Создать контактное лицо».

Шаг 3
Нажать на кнопку «Создать контактное лицо»
Ожидаемый результат:
Открыта страница создания контактного лица.

Шаг4
Заполнить обязательные поля:
фамилия;
имя;
организация;
должность.
Ожидаемый результат:
Поля заполнены.

Шаг 5
Нажать на кнопку «Сохранить и закрыть»
Ожидаемый результат:
Страница создания контактного лица закрыта,
пользователь видит страницу «Все контактные лица» и всплывающее уведомление «Контактное лицо сохранено».
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class CreatingContactPerson {
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
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_contact_index']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn back icons-holder-text ']")));
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Super");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[firstName]")));
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Testmen");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("123");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> allOrganization = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        allOrganization.get(1).click();

        //Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_contact[jobTitle]")));
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Tester");

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
    }
}

