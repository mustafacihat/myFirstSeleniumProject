package tests.day16;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utilities.ConfigurationReader;

public class PositiveLoginTest extends TestBase {

    @DataProvider
    public  Object [][] credentialsProvider(){

        String [][] data = {{ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password")},
                {ConfigurationReader.get("salesmanager_username"),ConfigurationReader.get("salesmanager_password")},
                {ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("salesmanager_password")}
        };

        return data;

    }

    @Test(dataProvider = "credentialsProvider")
    public void dataDriveTest(String username, String password){
        LoginPage loginPage = new LoginPage();

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");

    }



}


