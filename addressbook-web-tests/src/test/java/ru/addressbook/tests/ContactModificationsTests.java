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
            app.contact().create(new ContactData().withFirstName("Test").withMiddleName("test").withLastName("test")
                    .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                    .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                    .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                    .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().all();
        int index = before.size() - 1;
        ContactData contactData = new ContactData().withId(before.get(index).getiD()).withFirstName("Test").withMiddleName("test").withLastName("test")
                .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1");

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
