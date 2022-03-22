package HW_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesSubMenuCrm extends BaseWievCrm {
    public ExpensesSubMenuCrm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement expensesRequestsMenuItem;

    public void goToExpensesRequestsPage() {
        expensesRequestsMenuItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(ExpensesRequestPageCrm.createExpenseXpathLocator)));
    }
}