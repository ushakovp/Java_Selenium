package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size() + 1, after.size());

        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        before.add(group);

        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }


}
