package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String name = "John";

        String xpath = "//table[@id='table1']/tbody//td[.='"+name+"']/../td[3]";

        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }


}
