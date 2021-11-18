package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationsTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test1", "test", "test", "test"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().modifySelectedContact(before.size() - 1);

        ContactData contactData = new ContactData("Test2", "test2", "test2", "test2", "test2", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", null, "test", "test", "test");
        app.getContactHelper().fillContactform(contactData, false);
        app.getContactHelper().submitContactModification();
        app.goTo().gotoHomePage();


        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(contactData);
        Comparator<? super ContactData> byFullName = Comparator.comparing(ContactData::getFullName);
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }
}
