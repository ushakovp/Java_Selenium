package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoElement(By locator) {
        WebElement element = wd.findElement(locator);
        Actions actions = new Actions(wd);
        actions.moveToElement(element);
        actions.perform();

    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }
}
