package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class AnotherLoginTest {

    @Test
    public void test(){

        WebDriver driver = Driver.get();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement userNameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));

        userNameBox.sendKeys(ConfigurationReader.get("driver_username"));
        passwordBox.sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);

        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(fleet));
        actions.moveToElement(fleet).perform();

        WebElement vehicleModelButton = driver.findElement(By.xpath("//span[.='Vehicles Model']"));



        wait.until(ExpectedConditions.elementToBeClickable(vehicleModelButton));
        vehicleModelButton.click();

        WebElement number = driver.findElement(By.xpath("//input[@type='number']"));

        wait.until(ExpectedConditions.visibilityOf(number));

        Assert.assertEquals(number.getAttribute("value"),"1");

        Driver.closeDriver();

    }
}
