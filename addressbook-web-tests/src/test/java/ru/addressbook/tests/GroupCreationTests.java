package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");

        app.group().create(group);

        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size() + 1, after.size());

        group.withId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        before.add(group);

        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }


}
