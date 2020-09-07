package tests.day14;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class SingeltonTest {

    @Test
    public void singeltonTest(){


            String s1 = Singleton.getInstance();
            String s2 = Singleton.getInstance();

            System.out.println("s1 = " + s1);
            System.out.println("s2 = " + s2);


    }

    @Test
    public void test1(){
        WebDriver driver = Driver.get();

        driver.get("https://www.google.com");

        Driver.closeDriver();
    }

    @Test
    public void test2(){
        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com");

        Driver.closeDriver();
    }
}
