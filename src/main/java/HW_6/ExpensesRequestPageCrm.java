package HW_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesRequestPageCrm extends BaseWievCrm {
    public ExpensesRequestPageCrm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = createExpenseXpathLocator)
    public WebElement createExpenseButton;

    public CreateExpensePageCrm createExpense() {
        createExpenseButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(CreateExpensePageCrm.saveAndCloseButtonXpathLocator)));
        return new CreateExpensePageCrm(driver);
    }

    public static final String createExpenseXpathLocator = "//a[text()='Создать контактное лицо']";
}