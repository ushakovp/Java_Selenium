package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();

        ContactData contactData = new ContactData().withId(modifiedContact.getiD()).withFirstName("Test").withMiddleName("test").withLastName("test")
                .withNickName("test").withTitle("test").withCompany("test").withAddress("test").withHome("111").withMobile("222")
                .withWork("333").withFax("test").withEmail("test@test.ru").withEmail2("test@test.ru").withEmail3("test@test.ru")
                .withHomePage("test").withBday("17").withBmonth("December").withByear("2021")
                .withAday("18").withAmonth("October").withAyear("2020").withAddress2("test").withPhone2("test").withNotes("test").withGroup("test1");

        app.contact().modify(contactData);
        app.goTo().homePage();

        assertThat(before.size(), equalTo(app.contact().count()));

        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.without(modifiedContact).withAdded(contactData)));
    }
}
