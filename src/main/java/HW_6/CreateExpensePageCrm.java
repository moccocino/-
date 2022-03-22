package HW_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateExpensePageCrm extends BaseWievCrm {
    public CreateExpensePageCrm(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement expenseRequestLastName;

    public CreateExpensePageCrm lastName(String name) {
        expenseRequestLastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement expenseRequestFirstName;

    public CreateExpensePageCrm firstName(String name) {
        expenseRequestFirstName.sendKeys(name);
        return this;
    }

    @FindBy(name = "//span[text()='Укажите организацию']")
    public WebElement businessUnitSelect;

    public CreateExpensePageCrm selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement expenseRequestJob;

    public CreateExpensePageCrm Job(String name) {
        expenseRequestJob.sendKeys(name);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//*[text()='Заявка на расход сохранена']")
    public WebElement requestSavedSuccessfullyElement;
}



