package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void groupModificationPreconditions() {
        app.goTo().groupPage();
        if (!app.group().isThereAGroup()) {
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();

        app.group().delete(deletedGroup);

        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(deletedGroup);

        Assert.assertEquals(after, before);
    }


}
