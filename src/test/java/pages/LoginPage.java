package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }



    @FindBy(id="prependedInput")
    public WebElement usernameInput;


    @FindBy(css = "#prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginBtn;


    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();


    }

    public void loginAsDriver(){

        usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginBtn.click();
    }





}
