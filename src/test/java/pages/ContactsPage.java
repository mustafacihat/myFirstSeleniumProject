package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class ContactsPage extends BasePage {


    //create a method that accept email as a String and return webelement based on that email
    public WebElement getContactEmail(String email){
        return Driver.get().findElement(By.xpath("//td[contains(text(),'" + email + "')][@data-column-label='Email']"));
    }


}
