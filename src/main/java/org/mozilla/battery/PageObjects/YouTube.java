package org.mozilla.battery.PageObjects;

import com.google.common.base.FinalizableWeakReference;
import org.mozilla.battery.Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static org.mozilla.battery.PageObjConstants.Constants.YOUTUBE_SEARCH;
import static org.mozilla.battery.PageObjConstants.Constants.YOUTUBE_URL;

/**
 * Created by ionut.budeanu on 1/23/2018.
 */
public class YouTube extends BaseObject {

    @FindBy(id ="search-icon-legacy")
    WebElement searchButton;

    @FindBy(name = "search_query")
    WebElement searchBox;

    @FindBy(css = "a[href*='/watch?v=uWA-WWLIek0']")
    WebElement firstVideo;

    @FindBy(id ="logo-icon-container" )
    WebElement home;

    @FindBy(css ="a[href*='/feed/trending']")
    WebElement trending;

    //@FindAllB(xpath = "//*[contains(@class,'style-scope ytd-expanded-shelf-contents-renderer')]")
    @FindBy(className="style-scope ytd-expanded-shelf-contents-renderer")
    List<WebElement> trendingVideos;

    @FindBy(css = "ytd-browse.style-scope:nth-child(4) > ytd-two-column-browse-results-renderer:nth-child(7) > ytd-section-list-renderer:nth-child(1) > div:nth-child(3) > ytd-item-section-renderer:nth-child(1) > div:nth-child(3) > ytd-shelf-renderer:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ytd-expanded-shelf-contents-renderer:nth-child(1) > div:nth-child(1) > ytd-video-renderer:nth-child(1)")
    WebElement trendingVideo;

    @FindBy(css ="ytd-compact-video-renderer.ytd-compact-autoplay-renderer > div:nth-child(1) > a:nth-child(2)")
    WebElement upNextVideo;

    //@FindAll


    public void accessYouTube() {
        navigateToUrl(YOUTUBE_URL);
    }

    public void searchYouTube() {
        sendKeysAndPressEnter(searchBox, YOUTUBE_SEARCH);
    }

    public void accessFirstVideo() {
        click(firstVideo);
        driverSleep(3000);
    }

    public void accessHome() {
        click(home);
    }

    public void accessTrending() {
        click(trending);
        driverSleep(2000);
    }

    public void accessTrendingVideo() {
        click(trendingVideo);
        driverSleep(4000);
    }

    public void accessUpNextVideo() {

        click(upNextVideo);
        driverSleep(10000);

    }

    public void runAllScenarious() {
        accessYouTube();
        searchYouTube();
        accessFirstVideo();
        accessHome();
        accessTrending();
        accessTrendingVideo();
        accessUpNextVideo();
    }


}
