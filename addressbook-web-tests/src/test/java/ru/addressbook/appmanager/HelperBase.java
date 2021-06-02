package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected final WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (!wd.findElement(locator).getAttribute("value").equals(text)) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    protected void selectFromList(By locator, String text) {
        click(locator);
        new Select(wd.findElement(locator)).selectByVisibleText(text);
        click(locator);
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void gotoElement(By locator) {
        WebElement element = wd.findElement(locator);
        Actions actions = new Actions(wd);
        actions.moveToElement(element);
        actions.perform();

    }
}
