package tests.day16;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventsPage;
import pages.Dashboard;
import pages.LoginPage;
import tests.TestBase;
import utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {


    /*VERIFY RADIO BUTTONS
   Open browser
   Login as driver
   Go to Activities->Calendar Events
   Click on create calendar events
   Click on repeat
   Verify that repeat every days is checked
   verify that repeat weekday is not checked
   * */


    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        BrowserUtils.waitFor(3);
        Dashboard dashboard = new Dashboard();
        dashboard.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEvents = new CalendarEventsPage();
        calendarEvents.createCalendarEvent.click();
        calendarEvents.waitUntilLoaderScreenDisappear();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());

    }

    /*
VERIFY REPEAT OPTIONS
  Open browser
  Login as driver
  Go to Activities->Calendar
  Click on create calendar events
  Click on repeat checkbox
  Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
*/
    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        BrowserUtils.waitFor(3);
        Dashboard dashboard = new Dashboard();
        dashboard.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);
        CalendarEventsPage calendarEvents = new CalendarEventsPage();
        calendarEvents.createCalendarEvent.click();
        calendarEvents.waitUntilLoaderScreenDisappear();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatDropDown = createCalendarEventsPage.repeatOptionsList();

        List<WebElement> options = repeatDropDown.getOptions();

        /*for (WebElement option : options) {
            System.out.println(option.getText());
        }*/

        List<String> elementsTextActual = BrowserUtils.getElementsText(options);

        List<String> expected = new ArrayList<>(Arrays.asList("Daily","Weekly","Monthly","Yearly"));

        Assert.assertEquals(elementsTextActual,expected,"verify the dropdown options");


    }
}
