package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "div.btn-group.actions-group>div")
    public WebElement options;

    @FindBy(css = "input[type=number]")
    public WebElement pageNumber;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement viewPerPage;

    @FindBy(css = "i.fa-chevron-right.hide-text")
    public WebElement nextPage;

   /* @FindBy(xpath = "//table/tbody[@class='grid-body']/tr")
    public WebElement allRows;*/

    @FindBy(css = "button[data-toggle='dropdown']>input[type='checkbox']")
    public WebElement allCheckBox;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement numberOfPage;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement record;


    public WebElement getCalendarEventTitle(String title) {

        return Driver.get().findElement(By.xpath("//table/tbody/tr/td[.='" + title + "'][@data-column-label='Title']"));
    }


    public Integer getNumberOfPages() {

        String[] pages = numberOfPage.getText().split(" ");
        Integer pagesNumber = Integer.parseInt(pages[1]);
        return pagesNumber;
    }

    public List<WebElement> allGridCheckBox() {
        List<WebElement> checkBoxes = Driver.get().findElements(By.xpath("//tr[*]//td[1]/input"));
        ////table//tbody/tr[@class='grid-row row-click-action'][" + i + "]/td[1]/input
        return checkBoxes;
    }


    public String totalRow() {

        Integer totalRow = 0;
        for (int i = 1; i <= getNumberOfPages(); i++) {
            List<WebElement> elements = Driver.get().findElements(By.xpath("//table/tbody[@class='grid-body']/tr"));
            totalRow += elements.size();


            BrowserUtils.clickWithJS(nextPage);
            BrowserUtils.waitFor(2);

        }
        return String.valueOf(totalRow);
    }



}
