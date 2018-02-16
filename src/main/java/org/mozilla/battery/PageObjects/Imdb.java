package org.mozilla.battery.PageObjects;

/**
 * Created by ionut.budeanu on 1/30/2018.
 */

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mozilla.battery.PageObjConstants.Constants.IMDB_SEARCH;
import static org.mozilla.battery.PageObjConstants.Constants.IMDB_URL;

public class Imdb extends BaseObject {

    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(css = "a[href*='/title/tt0120737/?ref_=fn_al_tt_1']")
    WebElement firstResult;

    @FindBy(css = "a[href*='/title/tt0120737/mediaviewer/rm3592958976?ref_=tt_ov_i']")
    WebElement poster;

    @FindBy(css = "a[href*='/video/imdb/vi2073101337?playlistId=tt0120737&ref_=tt_ov_vi']")
    WebElement video;


    public void accessImdb() {
        navigateToUrl(IMDB_URL);
    }

    public void searchImdb() {
        sendKeysAndPressEnter(searchField, IMDB_SEARCH);
    }

    public void accessFirstResult() {
        click(firstResult);
        driverSleep(1000);
    }

    public void accessPoster() {
        click(poster);
        driverSleep(1000);
    }

    public void backButton() {
        navigateBack();
    }

    public void accessVideo() {
        click(video);
    }

    public void runAllScenarious() {
        accessImdb();
        searchImdb();
        accessFirstResult();
        accessPoster();
        backButton();
        accessVideo();
    }


}
