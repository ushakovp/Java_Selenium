package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactform(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomePage());
        selectFromList(By.name("bday"), contactData.getBday());
        selectFromList(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        selectFromList(By.name("aday"), contactData.getAday());
        selectFromList(By.name("amonth"), contactData.getAmonth());
        type(By.name("ayear"), contactData.getAyear());
        if (creation) {
            selectFromList(By.name("new_group"), contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void delete(ContactData contact) {
        click(By.id(String.valueOf(contact.getiD())));
        click(By.xpath("//input[@value='Delete']"));
    }

    private void modifyContactById(int iD) {
        click(By.xpath("//a[@href='edit.php?id=" + iD + "']"));
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactform(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(ContactData contactData) {
        modifyContactById(contactData.getiD());
        fillContactform(contactData, false);
        submitContactModification();
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
            String[] allData = element.getText().split(" ");
            String name = allData[1];
            String lastName = allData[0];
            contacts.add(new ContactData().withId(id).withFirstName(name).withLastName(lastName));
        }
        return contacts;
    }

}
