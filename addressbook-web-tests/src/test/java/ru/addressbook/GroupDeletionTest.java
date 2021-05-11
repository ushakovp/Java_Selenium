package ru.addressbook;

import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }

}
