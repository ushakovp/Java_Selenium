package ru.addressbook.tests;

import org.junit.jupiter.api.Test;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        app.getContactHelper().initContactDeletion();
        app.getNavigationHelper().acceptAlert();
    }
}
