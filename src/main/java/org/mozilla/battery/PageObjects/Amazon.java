package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.mozilla.battery.PageObjConstants.Constants.AMAZON_URL;
import static org.mozilla.battery.PageObjConstants.Constants.AMAZON_SEARCH;

/**
 * Created by ionut.budeanu on 1/23/2018.
 */
public class Amazon extends BaseObject {

    static By SearchBox = By.id("twotabsearchtextbox");
    static By VideoElement = By.xpath("//*[contains(text(),'The Lord Of The Rings: The Fellowship Of The Ring')]");
    static By WatchTrailerButton = By.xpath("//a[contains(@href,'/gp/video/detail/B000YMH4CG/ref=atv_dp_pb_tr?autoplay=trailer')]");
    static By BookElement = By.xpath("//*[contains(text(),'The Lord of the Rings: 50th Anniversary, One Vol. Edition')]");
    static By BookThumbnail = By.id("img-canvas");



    public void accessAmazon() {
        navigateToUrl(AMAZON_URL);
    }

    public void searchItem() {
        sendKeysAndPressEnter(SearchBox, AMAZON_SEARCH);
    }

    public void accessVideoElement() {
        WebElement video = getElement(VideoElement);
        click(video);
    }

    public void watchTrailer() {
        WebElement watchTrailerButton = getElement(WatchTrailerButton);
        click(watchTrailerButton);
        driverSleep(5000);
    }

    public void backButton() {
        navigateBack();
    }

    public void accessBookElement() {
        WebElement book = getElement(BookElement);
        click(book);
    }

    public void openBook() {
        WebElement thumbnail = getElement(BookThumbnail);
        click(thumbnail);
    }

    public void runAllFlows() {
        accessAmazon();
        searchItem();
        accessVideoElement();
        watchTrailer();
        backButton();
        accessBookElement();
        openBook();
    }


}
