package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import utilities.Driver;

public class StaleTest extends TestBase {


    @Test
    public void test1(){
        driver.get("https://www.google.com");

        WebElement input = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));

        input.sendKeys("Mercedes"+ Keys.ENTER);

        WebElement results = driver.findElement(By.cssSelector("div#result-stats"));

        Assert.assertTrue(results.isDisplayed());

        driver.navigate().back();

        input = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        input.sendKeys("BMW"+Keys.ENTER);

        results = driver.findElement(By.cssSelector("div#result-stats"));
        Assert.assertTrue(results.isDisplayed());

    }


}
