package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();

        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");

        app.group().create(group);

        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size() + 1, after.size());

        group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
