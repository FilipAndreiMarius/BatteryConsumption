package PageObjects;

import Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static PageObjConstants.Constants.YOUTUBE_URL;
import static PageObjConstants.Constants.YOUTUBE_SEARCH;

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
    static By UpNextVideo =  By.className("style-scope ytd-compact-video-renderer");


    public YouTube(){
        setUp();
    }

    public void accessYouTube(){
        navigateToUrl(YOUTUBE_URL);
    }

    public void searchYouTube(){
        sendKeys(SearchBox, YOUTUBE_SEARCH);
        click(SearchButton);

    }

    public void accessFirstVideo() throws InterruptedException {
        WebElement firstVideo = getElement(FirstVideo);
        click(firstVideo);
        driverSleep(3000);
    }

    public void accessHome(){
        WebElement home = getElement(Home);
        click(home);
    }

    public void accessTrending() throws InterruptedException {
        WebElement trending = getElement(Trending);
        click(trending);
        driverSleep(2000);
    }

    public void accessTrendingVideo() throws InterruptedException {
        WebElement trendingVideo = getElement(TrendingVideo);
        click(trendingVideo);
        driverSleep(2000);
    }

    public void upNextVideo(){
       List<WebElement> video = getElements(UpNextVideo);
       video.get(2).click();

    }

    public void runAllScenarious() throws InterruptedException {
        accessYouTube();
        searchYouTube();
        accessFirstVideo();
        accessHome();
        accessTrending();
        accessTrendingVideo();
    }


}
