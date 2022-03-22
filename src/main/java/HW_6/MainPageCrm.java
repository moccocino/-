package HW_6;

import org.openqa.selenium.WebDriver;

public class MainPageCrm extends BaseWievCrm {
    public HW_6.NavigationMenuCrm navigationMenu;

    public MainPageCrm(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenuCrm(driver);
    }
}