package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("Test").withMiddleName("test").withLastName("test")
                .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1");

        app.contact().create(contact, true);

        Set<ContactData> after = app.contact().all();

        contact.withId(after.stream().mapToInt(ContactData::getiD).max().getAsInt());
        before.add(contact);

        Assert.assertEquals(before.size(), after.size());

        Assert.assertEquals(before, after);
    }


}
