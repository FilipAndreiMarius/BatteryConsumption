package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.mozilla.battery.PageObjConstants.Constants.AMAZON_SEARCH;
import static org.mozilla.battery.PageObjConstants.Constants.AMAZON_URL;

/**
 * Created by ionut.budeanu on 1/23/2018.
 */
public class Amazon extends BaseObject {

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(xpath = "//*[contains(text(),'The Lord Of The Rings: The Fellowship Of The Ring')]")
    WebElement videoElement;

    @FindBy(xpath = "//a[contains(@href,'/gp/video/detail/B000YMH4CG/ref=atv_dp_pb_tr?autoplay=trailer')]")
    WebElement watchTrailerButton;

    @FindBy(xpath ="//*[contains(text(),'The Lord of the Rings: 50th Anniversary, One Vol. Edition')]" )
    WebElement bookElement;

    @FindBy(id ="img-canvas" )
    WebElement bookThumbnail;


    public void accessAmazon() {
        navigateToUrl(AMAZON_URL);
    }

    public void searchItem() {
        sendKeysAndPressEnter(searchBox, AMAZON_SEARCH);
    }

    public void accessVideoElement() {
        click(videoElement);
    }

    public void watchTrailer() {
        click(watchTrailerButton);
        driverSleep(10000);
    }

    public void backButton() {
        navigateBack();
    }

    public void accessBookElement() {
        click(bookElement);
    }

    public void openBook() {
        click(bookThumbnail);
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
