package org.mozilla.battery.PageObjects;

import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static org.mozilla.battery.PageObjConstants.Constants.YOUTUBE_URL;
import static org.mozilla.battery.PageObjConstants.Constants.YOUTUBE_SEARCH;

/**
 * Created by ionut.budeanu on 1/23/2018.
 */
public class YouTube extends BaseObject {

    static By SearchButton = By.id("search-icon-legacy");
    static By SearchBox = By.name("search_query");
    static By FirstVideo = By.cssSelector("a[href*='/watch?v=xIhEJuCPzZ8']");
    static By Home = By.id("logo-icon-container");
    static By Trending = By.cssSelector("a[href*='/feed/trending']");
    static By TrendingVideo = By.cssSelector("a[href*='/watch?v=yW1z_OsKSi0']");
    static By UpNextVideo = By.className("style-scope ytd-compact-video-renderer");



    public void accessYouTube() {
        navigateToUrl(YOUTUBE_URL);
    }

    public void searchYouTube() {
        sendKeys(SearchBox, YOUTUBE_SEARCH);
        click(SearchButton);

    }

    public void accessFirstVideo() {
        WebElement firstVideo = getElement(FirstVideo);
        click(firstVideo);
        driverSleep(3000);
    }

    public void accessHome() {
        WebElement home = getElement(Home);
        click(home);
    }

    public void accessTrending() {
        WebElement trending = getElement(Trending);
        click(trending);
        driverSleep(2000);
    }

    public void accessTrendingVideo() {
        WebElement trendingVideo = getElement(TrendingVideo);
        click(trendingVideo);
        driverSleep(2000);
    }

    public void upNextVideo() {
        List<WebElement> video = getElements(UpNextVideo);
        video.get(2).click();

    }

    public void runAllScenarious() {
        accessYouTube();
        searchYouTube();
        accessFirstVideo();
        accessHome();
        accessTrending();
        accessTrendingVideo();
    }


}
