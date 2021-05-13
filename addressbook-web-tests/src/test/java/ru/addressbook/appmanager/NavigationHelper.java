package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper {
    private final ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void gotoElement(String name){
        WebElement element = wd.findElement(By.name(name));
        Actions actions = new Actions(wd);
        actions.moveToElement(element);
        actions.perform();

    }
}
