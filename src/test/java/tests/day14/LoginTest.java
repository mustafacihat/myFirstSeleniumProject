package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.TestBase;
import utilities.ConfigurationReader;
import utilities.Driver;


public class LoginTest  {


    @Test
    public void test1(){
       Driver.get();

       Driver.get().get(ConfigurationReader.get("url"));

        WebElement userName = Driver.get().findElement(By.cssSelector("#prependedInput"));
        userName.sendKeys(ConfigurationReader.get("driver_username"));
        WebElement password = Driver.get().findElement(By.cssSelector("#prependedInput2"));
        password.sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);

    }
}
