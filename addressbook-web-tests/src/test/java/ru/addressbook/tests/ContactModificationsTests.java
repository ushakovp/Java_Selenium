package ru.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.addressbook.model.ContactData;

public class ContactModificationsTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test3", "test", "test", "test"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactform(new ContactData("Test2", "test2", "test2", "test2", "test2", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", null, "test", "test", "test"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
