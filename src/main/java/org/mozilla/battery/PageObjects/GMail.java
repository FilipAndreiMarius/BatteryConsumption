package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.mozilla.battery.PageObjConstants.Constants.*;

public class GMail extends BaseObject {

    @FindBy(id ="identifierId")
    WebElement userMailField;

    @FindBy(id = "identifierNext")
    WebElement nextButton;

    @FindBy(name = "password")
    WebElement userPasswordField;

    @FindBy(className ="CwaK9")
    WebElement submitPasswordButton;

    @FindBy(css = "a[href*='https://www.youtube.com/watch?v=G2944Wc2V_4']")
    WebElement emailYoutubeLink;

    @FindBy(css = "a[href*='https://mail.google.com/mail/u/0/#inbox']")
    WebElement inboxButton;

    @FindBy(css = ".gb_ab")
    WebElement accountOptions;

    @FindBy(id = "gb_71")
    WebElement signOutButton;

    @FindBy(name = "identifier")
    WebElement identifier;

    @FindBy(xpath="//*[@class='yW']/span")
    List<WebElement> allEmailSenders;

    @FindBy(name = "search_query")
    WebElement searchField;

    public void accesGmail() {
        navigateToUrl(GMAIL_URL);
    }

    public void logIn()  {

        if(identifier.isDisplayed() ) {
            sendKeys(userMailField,GMAIL_USERNAME);
            click(nextButton);

            driverSleep(1000);
            sendKeys(userPasswordField, GMAIL_PASSWORD);
            click(submitPasswordButton);
            driverSleep(10000);
        }
        else {
            sendKeys(userPasswordField, GMAIL_PASSWORD);
            click(submitPasswordButton);
            driverSleep(7000);
        }
    }


    public void accessEmailSender1() {

        for(int i=0;i<allEmailSenders.size();i++){
            System.out.println(allEmailSenders.get(i).getText());
            if(allEmailSenders.get(i).getText().equals(GMAIL_SENDER1)){
                allEmailSenders.get(i).click();
            }
        }
    }

    public void firstEmailLink() {
        String parent=driver.getWindowHandle();
        click(emailYoutubeLink);
        driverSleep(8000);
        closeAllTabsExceptFirst();
    }

    public void accessInbox() {
        click(inboxButton);
        driverSleep(1000);
    }

    public void accessEmailSender2()  {
        for(int i=0;i<allEmailSenders.size();i++){
            System.out.println(allEmailSenders.get(i).getText());
            if(allEmailSenders.get(i).getText().equals(GMAIL_SENDER2)){
                allEmailSenders.get(i).click();
            }
        }
    }

    public void logOut(){
        click(accountOptions);
        driverSleep(1000);
        click(signOutButton);
    }


    public void runAllFlows(){
        accesGmail();
        logIn();
        accessEmailSender1();
        firstEmailLink();
        accessInbox();
        accessEmailSender2();
        logOut();
    }

}


