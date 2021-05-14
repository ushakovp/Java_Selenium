package ru.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.addressbook.model.GroupData;

public class GroupModificationsTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().modifySelectedGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test3", "test3", "test3"));
        app.getGroupHelper().updateSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
