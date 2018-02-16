package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mozilla.battery.PageObjConstants.Constants.*;

public class GoogleSearch extends BaseObject {


    @FindBy(id="gb_70")
    WebElement buttonLogin;

    @FindBy(id ="identifierId")
    WebElement userMailField;

    @FindBy(id = "identifierNext")
    WebElement nextButton;

    @FindBy(name = "password")
    WebElement userPasswordField;

    @FindBy(className ="CwaK9")
    WebElement submitPasswordButton;

    @FindBy(id = "lst-ib")
    WebElement searchField;

    @FindBy(linkText = "Images")
    WebElement imagesButton;

    @FindBy(linkText = "News")
    WebElement newsButton;

    @FindBy(linkText = "Videos")
    WebElement videosButton;

    @FindBy(css = ".gb_ab")
    WebElement accountOptions;

    @FindBy(id = "gb_71")
    WebElement signOutButton;

    @FindBy(name = "identifier")
    WebElement identifier;

    public void accessGoogle() {
        navigateToUrl(GOOGLE_URL);
    }

    public void logIn()  {
        click(buttonLogin);
        if(identifier.isDisplayed() )
        {
            sendKeys(userMailField,GOOGLE_USERNAME);
            click(nextButton);

            driverSleep(1000);
            sendKeys(userPasswordField,GOOGLE_PASSWORD);
            click(submitPasswordButton);
        }
        else
        {
            sendKeys(userPasswordField,GOOGLE_PASSWORD);
            click(submitPasswordButton);
        }
    }

    public void search() {
        sendKeysAndPressEnter(searchField,GOOGLE_SEARCH_KEYWORDS);
    }

    public void accessImages()  {
        click(imagesButton);
      //  Thread.sleep(1000);
    }

    public void accessNews()  {
        click(newsButton);
     //   Thread.sleep(1000);
    }

    public void accessVideos(){
        click(videosButton);
    }
    public void logOut(){
        click(accountOptions);
        driverSleep(1000);
        click(signOutButton);
    }

    public void runAllFlows() {
        accessGoogle();
        logIn();
        search();
        accessImages();
        accessNews();
        accessVideos();
        logOut();
    }

}