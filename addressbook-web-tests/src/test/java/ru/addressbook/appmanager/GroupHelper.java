package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup(int num) {
        wd.findElements(By.name("selected[]")).get(num).click();
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void modifySelectedGroup() {
        click(By.name("edit"));
    }

    public void updateSelectedGroup() {
        click(By.name("update"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        gotoElement(By.name("submit"));
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
