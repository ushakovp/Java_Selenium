package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void contactDeletionPreconditions() {
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test3", "test", "test", "test"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().all();
        app.contact().initContactDeletion();
        app.goTo().acceptAlert();
        app.goTo().homePage();
        List<ContactData> after = app.contact().all();
        before.remove(0);

        Assert.assertEquals(after, before);

    }
}
