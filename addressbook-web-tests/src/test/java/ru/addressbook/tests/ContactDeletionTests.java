package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test3", "test", "test", "test"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactDeletion();
        app.goTo().acceptAlert();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(0);

        Assert.assertEquals(after, before);

    }
}
