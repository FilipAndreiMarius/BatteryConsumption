package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mozilla.battery.PageObjConstants.Constants.*;

public class Twitter extends BaseObject {

    @FindBy(name = "session[username_or_email]")
    WebElement userNameField;

    @FindBy(name = "session[password]")
    WebElement userPasswordField;

    @FindBy(css = "input.EdgeButton:nth-child(3)")
    WebElement submitLoginButton;

    @FindBy(css = ".u-textInheritColor")
    WebElement userProfile;

    @FindBy(xpath = "//img[@src='https://pbs.twimg.com/media/DTLzqs2WAAAbRV7.jpg']")
    WebElement imageTweett;

    @FindBy(css = ".Gallery-content > button:nth-child(1)")
    WebElement closeButton;

    @FindBy(id = "global-nav-home")
    WebElement homeButton;

    @FindBy(id = "search-query")
    WebElement searchField;

    @FindBy(linkText = "People")
    WebElement peopleSection;

    @FindBy(css = "a[href*='/Ffox21']")
    WebElement peopleSelect;

    @FindBy(xpath = "//img[@src='https://pbs.twimg.com/media/DTL1FA_X4AEw-47.jpg']")
    WebElement imageTweet2ndProfile;

    @FindBy(id="user-dropdown-toggle")
    WebElement profileSettingsDropdown;

    @FindBy(id="signout-button")
    WebElement logOutOption;

    public void accesTwitter() {
        navigateToUrl(TWITTER_URL);
    }

    public void logIn()  {
        sendKeys(userNameField,TWITTER_USERNAME);
        sendKeys(userPasswordField,TWITTER_PASSWORD);
        click(submitLoginButton);
        driverSleep(1000);
    }

    public void accessUserProfile()  {
        click(userProfile);
        driverSleep(1000);
    }

    public void accessTweetImage()  {
        click(imageTweett);
        driverSleep(1000);
    }

    public void closeImage(){
        click(closeButton);
    }

    public void accessHome(){
        click(homeButton);
    }

    public void search()  {
        sendKeys(searchField,TWITTER_SEARCH_KEYWORDS);
        searchField.submit();
        driverSleep(2000);
    }

    public void accessPeople()  {
        click(peopleSection);
        driverSleep(1000);
    }

    public void accessFfox2Profile()  {
        click(peopleSelect);
        driverSleep(2000);
    }

    public void accessUserPhotoTweet() {
        click(imageTweet2ndProfile);
        driverSleep(1000);
        closeImage();
        driverSleep(5000);
    }
    public void logOut(){
        click(profileSettingsDropdown);
        driverSleep(1000);
        click(logOutOption);
    }

    public void runAllFlows(){
        accesTwitter();
        logIn();
        accessUserProfile();
        accessTweetImage();
        closeImage();
        accessHome();
        search();
        accessPeople();
        accessFfox2Profile();
        accessUserPhotoTweet();
        logOut();
    }
}

