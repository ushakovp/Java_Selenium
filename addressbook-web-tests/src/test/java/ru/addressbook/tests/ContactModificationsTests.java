package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationsTests extends TestBase {

    @BeforeMethod
    private void contactModificationPreconditions() {
        if (!app.contact().isThereAContact()) {
            app.contact().create(new ContactData().withFirstName("Test").withMiddleName("test").withLastName("test")
                    .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                    .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                    .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                    .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        int index = before.size() - 1;

        //withId(before.get(index).getiD()).
        ContactData contactData = new ContactData().withFirstName("Test").withMiddleName("test").withLastName("test")
                .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1");

        app.contact().modify(index, contactData);
        app.goTo().homePage();


        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contactData);
        Assert.assertEquals(before, after);
    }
}
