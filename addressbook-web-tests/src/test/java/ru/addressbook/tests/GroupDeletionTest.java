package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.List;

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
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;

        app.group().delete(index);

        List<GroupData> after = app.group().list();
        Assert.assertEquals(index, after.size());

        before.remove(index);
        for (int i = 0; i < after.size(); i++) {
            Assert.assertEquals(before.get(i), after.get(i));
        }
        Assert.assertEquals(after, before);
    }


}
