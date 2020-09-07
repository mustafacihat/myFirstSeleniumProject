package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestBase;
import utilities.ConfigurationReader;
import utilities.Driver;

public class VytrackTest extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigurationReader.get("url"));

        WebElement userName = driver.findElement(By.cssSelector("#prependedInput"));
        userName.sendKeys(ConfigurationReader.get("driver_username"));
        WebElement password = driver.findElement(By.cssSelector("#prependedInput2"));
        password.sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);

    }
}
