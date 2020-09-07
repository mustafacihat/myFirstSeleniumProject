package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.Dashboard;
import pages.LoginPage;
import tests.TestBase;
import utilities.BrowserUtils;

public class PageSubtitleTest extends TestBase {


    /* Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events*/


    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        Dashboard dashboard = new Dashboard();

        String expected = "Quick Launchpad";
        String actual = dashboard.getPageSubTitle();

        Assert.assertEquals(actual,expected,"Verify subtitle is Quict Launchpad");

    }

    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        BrowserUtils.waitFor(5);
        Dashboard dashboard = new Dashboard();

        dashboard.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String actualResult = calendarEventsPage.getPageSubTitle();

        String expectedResult ="Calendar Events";


        Assert.assertEquals(actualResult,expectedResult,"verify subtitle is Calendar Events");


    }

}
