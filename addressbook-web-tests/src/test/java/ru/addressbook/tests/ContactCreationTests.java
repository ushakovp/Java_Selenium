package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().all();
        ContactData contact = new ContactData("Test", "test", "test", "test", "test", "test", "test", "111", "222", "333", "test", "test@test.ru", "test@test.ru", "test@test.ru", "test", "17", "December", "2021", "18", "October", "2020", "test1", "test", "test", "test");
        app.contact().create(contact, true);

        List<ContactData> after = app.contact().all();
        before.add(contact);
        Assert.assertEquals(before.size(), after.size());

        Comparator<? super ContactData> byFullName = Comparator.comparing(ContactData::getFullName);
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }


}
