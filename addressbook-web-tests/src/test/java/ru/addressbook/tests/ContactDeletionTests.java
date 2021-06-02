package ru.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test3", "test", "test", "test"), true);
        }
        app.getContactHelper().initContactDeletion();
        app.getNavigationHelper().acceptAlert();
    }
}
