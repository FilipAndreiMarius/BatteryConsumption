package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mozilla.battery.PageObjConstants.Constants.WIKI_SEARCH;
import static org.mozilla.battery.PageObjConstants.Constants.WIKI_URL;

/**
 * Created by ionut.budeanu on 1/29/2018.
 */
public class Wikipedia extends BaseObject {


    @FindBy(name = "search")
    WebElement searchField;

    @FindBy(css = "a[href*='/wiki/File:President_Barack_Obama.jpg']")
    WebElement photo;

    @FindBy(id = "ca-talk")
    WebElement talkSection;

    public void accessWiki() {
        navigateToUrl(WIKI_URL);
    }

    public void searchWiki() {
        sendKeysAndPressEnter(searchField, WIKI_SEARCH);
        driverSleep(2000);
    }

    public void accessPhoto() {
        click(photo);
    }

    public void goBack() {
        navigateBack();
    }

    public void accessTalkSection() {
        click(talkSection);
    }

    public void runAllFlows() {
        accessWiki();
        searchWiki();
        accessPhoto();
        goBack();
        accessTalkSection();
    }


}
