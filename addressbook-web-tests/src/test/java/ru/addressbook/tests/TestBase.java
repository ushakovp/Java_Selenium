package ru.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.BrowserType;
import ru.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeEach
    public void setUp() {
        app.init();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }

}
