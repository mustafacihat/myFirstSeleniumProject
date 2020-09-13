package tests.day17;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utilities.ConfigurationReader;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //name of the test for report
        extentLogger = report.createTest("TC 129(Wrong Password Test)");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("User1");
        extentLogger.info("Enter username: User1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("click login button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

        extentLogger.pass("TC 129 test is passed");

    }

    @Test
    public void wrongUsernameTest(){
        //name of the test for report
        extentLogger = report.createTest("TC 130(Wrong Username Test)");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("click login button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/loginn");

        extentLogger.pass("TC 130 test is passed");

    }


}
