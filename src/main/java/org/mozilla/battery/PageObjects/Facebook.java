package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.mozilla.battery.PageObjConstants.Constants.FACEBOOK_PASSWORD;
import static org.mozilla.battery.PageObjConstants.Constants.FACEBOOK_URL;
import static org.mozilla.battery.PageObjConstants.Constants.FACEBOOK_USERMANE;

/**
 * Created by ionut.budeanu on 1/18/2018.
 */
public class Facebook extends BaseObject {

    static By UsernameField = By.id("email");
    static By PasswordField = By.id("pass");
    static By LogIn = By.id("loginbutton");
    static By Group = By.className("_5afe");
    static By PhotoGroup = By.xpath("//a[contains(@href,'https://www.facebook.com/photo.php?fbid=111688719577080&set=gm.1014157412059824&type=3&ifg=1')]");
    static By HomeButton = By.className("_2s25");
    static By FirstUser = By.className("fwb");
    static By VideosSection = By.className("_46-h");
    static By FirstUserVideo = By.xpath("//a[contains(@href,'/benchmarkautomation.ffox.5/videos/vb.100022078574252/187141978698420/?type=3')]");


    public void accessFacebook() {
        navigateToUrl(FACEBOOK_URL);
    }

    public void logIn() {
        sendKeys(UsernameField, FACEBOOK_USERMANE);
        sendKeys(PasswordField, FACEBOOK_PASSWORD);
        WebElement logIn = getElement(LogIn);
        click(logIn);
    }

    public void accessGroup() {
        WebElement group = getElements(Group).get(3);
        click(group);
        driverSleep(1000);
    }

    public void accessGroupPhoto() {

        WebElement groupPhoto = getElement(PhotoGroup);
        click(groupPhoto);
    }

    public void backButton() {
        navigateBack();
    }

    public void homeButton() {

        WebElement home = getElements(HomeButton).get(1);
        click(home);
    }

    public void accessFirstUser() {

        WebElement firstUser = getElement(FirstUser);
        click(firstUser);
        driverSleep(2000);
    }

    public void accessVideosSection() {

        List<WebElement> videosSection = getElements(VideosSection);
        videosSection.get(0).click();
    }

    public void accessFirstUserVideo() {

        WebElement firstUserVideo = getElement(FirstUserVideo);
        click(firstUserVideo);
    }


    public void runAllFlows() {
        accessFacebook();
        logIn();
        accessGroup();
        accessGroupPhoto();
        backButton();
        homeButton();
        accessFirstUser();
        accessVideosSection();
        accessFirstUserVideo();
    }


}
