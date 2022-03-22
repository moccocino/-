package Lesson_6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Заявка на расходы")
public class PageObjectTest extends BaseTest {

    @Test
    @Description("Тест на логин и создание заявки на расходы")
    void loginInCrmWithPageObjTest() {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Расходы");

        new ExpensesSubMenu(driver).goToExpensesRequestsPage();

        new ExpensesRequestsPage(driver)
                .createExpense()
                .fillName("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectCurrency("Доллар США")
                .fillSumPlan("1000")
                .selectDatePlan("20")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        assertThat(new CreateExpensePage(driver).requestSavedSuccessfullyElement, isDisplayed());
    }
}