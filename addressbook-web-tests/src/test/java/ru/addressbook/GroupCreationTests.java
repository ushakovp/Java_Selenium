package ru.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
    ChromeDriver wd;

    @BeforeEach
    public void setUp () throws Exception{
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        wd.findElement(By.name(("user"))).click();
        wd.findElement(By.name(("user"))).clear();
        wd.findElement(By.name(("user"))).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testGroupCreation(){

    }

}
