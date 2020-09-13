package tests.day18;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactInfoPage;
import pages.ContactsPage;
import pages.Dashboard;
import pages.LoginPage;
import tests.TestBase;
import utilities.ConfigurationReader;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest() {
        extentLogger = report.createTest("ContactInfoVerification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("username" + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password" + ConfigurationReader.get("salesmanager_password"));
        extentLogger.info("Login as salesmanager");
        loginPage.login(ConfigurationReader.get("salesmanager_username"), ConfigurationReader.get("salesmanager_password"));
        extentLogger.info("Navigate to Customers -- Contacts");
        new Dashboard().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();
        extentLogger.info("Verify fullname is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

        String expectedEmail = "mbrackstone9@example.com";
        String actualEmail = contactInfoPage.email.getText();
        extentLogger.info("Verify email is " + expectedEmail);
        Assert.assertEquals(actualEmail,expectedEmail,"verify email");


        String expectedPhone= "+18982323434";
        String actualPhone = contactInfoPage.phone.getText();
        extentLogger.info("Verify phone is " + expectedEmail);
        Assert.assertEquals(actualPhone,expectedPhone,"verify phone number");


        extentLogger.pass("PASSED: ContactInfoVerification test");


    }
}
