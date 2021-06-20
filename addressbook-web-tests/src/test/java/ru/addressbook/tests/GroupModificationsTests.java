package ru.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationsTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().modifySelectedGroup();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test3", "test3", "test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().updateSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assertions.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assertions.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
