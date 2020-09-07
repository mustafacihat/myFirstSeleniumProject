package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utilities.ConfigurationReader;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }


    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");


    }

    @Test
    public void loginTestWithMethod(){
        LoginPage loginPage = new LoginPage();

        loginPage.login(ConfigurationReader.get("driver_username"),"somepassword");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }

}
