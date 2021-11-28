package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationsTests extends TestBase {

    @BeforeMethod
    private void contactModificationPreconditions() {
        if (!app.contact().isThereAContact()) {
            app.contact().create(new ContactData("Test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test1", "test", "test", "test"), true);
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().all();
        int index = before.size() - 1;
        ContactData contactData = new ContactData("Test2", "test2", "test2", "test2", "test2", "test", "test", "111", "222", "333", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", null, "test", "test", "test");

        app.contact().modify(index, contactData);
        app.goTo().homePage();


        List<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contactData);
        Comparator<? super ContactData> byFullName = Comparator.comparing(ContactData::getFullName);
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }
}
