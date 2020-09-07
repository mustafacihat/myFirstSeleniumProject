package tests.day14;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.Scanner;


public class PropertiesTest {


    @Test
    public void test1(){


        System.out.println(ConfigurationReader.get("browser"));

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get("https://www.google.com");

        System.out.println(ConfigurationReader.get("url"));

    }
}
