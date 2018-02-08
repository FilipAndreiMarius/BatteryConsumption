package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.mozilla.battery.PageObjConstants.Constants.WIKI_URL;
import static org.mozilla.battery.PageObjConstants.Constants.WIKI_SEARCH;

/**
 * Created by ionut.budeanu on 1/29/2018.
 */
public class Wikipedia extends BaseObject {

    static By SearchField = By.name("search");
    static By Photo = By.cssSelector("a[href*='/wiki/File:President_Barack_Obama.jpg']");
    static By TalkSection = By.id("ca-talk");


    public void accessWiki() {
        navigateToUrl(WIKI_URL);
    }

    public void searchWiki() {
        sendKeysAndPressEnter(SearchField, WIKI_SEARCH);
        driverSleep(2000);
    }

    public void accessPhoto() {
        WebElement photo = getElement(Photo);
        click(photo);
    }

    public void goBack() {
        navigateBack();
    }

    public void accessTalkSection() {
        WebElement talk = getElement(TalkSection);
        click(talk);
    }

    public void runAllFlows() {
        accessWiki();
        searchWiki();
        accessPhoto();
        goBack();
        accessTalkSection();

    }


}
