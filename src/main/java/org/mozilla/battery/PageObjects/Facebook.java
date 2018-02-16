package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.mozilla.battery.PageObjConstants.Constants.*;

/**
 * Created by ionut.budeanu on 1/18/2018.
 */
public class Facebook extends BaseObject {


    @FindBy(id="email")
    WebElement usernameField;

    @FindBy(id="pass")
    WebElement passwordField;

    @FindBy(id="loginbutton")
    WebElement loginButton;

    @FindBy(css = "#navItem_1014156802059885 > a:nth-child(2) > div:nth-child(2)")
    WebElement groupLink;

    @FindBy(xpath = "//a[contains(@href,'https://www.facebook.com/photo.php?fbid=111688719577080&set=gm.1014157412059824&type=3&ifg=1')]")
    WebElement groupPhoto;

    @FindBy(css = "#u_0_b > a:nth-child(1)")
    WebElement homeButton;

    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(css = "._52eh")
    WebElement friendProfile;

    @FindBy(linkText = "Photos")
    WebElement mediaSection;

    @FindBy(xpath = "//a[contains(@href,'/benchmarkautomation.ffox.5/videos/vb.100022078574252/187141978698420/?type=2&video_source=user_video_tab')]")
    WebElement userVideo;

    @FindBy(id = "userNavigationLabel")
    WebElement dropdownLogOut;

    @FindBy(xpath = "//li[12]/a/span/span")
    WebElement logOutOption;


    public void accessFacebook() {
        navigateToUrl(FACEBOOK_URL);
    }

    public void logIn() {
        sendKeys(usernameField, FACEBOOK_USERMANE);
        sendKeys(passwordField, FACEBOOK_PASSWORD);
        click(loginButton);
    }

    public void accessGroup() {
        click(groupLink);
        driverSleep(1000);
    }

    public void accessGroupPhoto() {
        click(groupPhoto);
        driverSleep(1000);

    }

    public void backButton() {
        navigateBack();
    }

    public void homeButton() {
        click(homeButton);
        driverSleep(2000);
    }

    public void searchForUser(){
        sendKeysAndPressEnter(searchField,FACEBOOK_FRIEND_SEARCH);
        driverSleep(2000);
    }

    public void selectFriend(){
        click(friendProfile);
        driverSleep(1000);
    }

    public void accessPhotosSection(){
        click(mediaSection);
    }

    public void accessVideo(){
        click(userVideo);
        driverSleep(10000);
    }
    public void logOut(){
        click(dropdownLogOut);
        driverSleep(1000);
        click(logOutOption);
    }



    public void runAllFlows() {
        accessFacebook();
        logIn();
        accessGroup();
        accessGroupPhoto();
        backButton();
        homeButton();
        searchForUser();
        selectFriend();
        accessPhotosSection();
        accessVideo();
        logOut();
    }


}
