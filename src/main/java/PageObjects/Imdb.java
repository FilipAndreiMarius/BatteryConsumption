package PageObjects;

/**
 * Created by ionut.budeanu on 1/30/2018.
 */

import Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static PageObjConstants.Constants.IMDB_SEARCH;
import static PageObjConstants.Constants.IMDB_URL;

public class Imdb extends BaseObject {

    static By SearchField = By.name("q");
    static By FirstResult = By.cssSelector("a[href*='/title/tt0120737/?ref_=fn_al_tt_1']");
    static By Poster = By.cssSelector("a[href*='/title/tt0120737/mediaviewer/rm3592958976?ref_=tt_ov_i']");
    static By Video = By.cssSelector("a[href*='/video/imdb/vi2073101337?playlistId=tt0120737&ref_=tt_ov_vi']");


    public Imdb(){
        setUp();
    }

    public void accessImdb(){
        navigateToUrl(IMDB_URL);
    }

    public void searchImdb(){
        sendKeysAndPressEnter(SearchField, IMDB_SEARCH);
    }

    public void accessFirstResult() throws InterruptedException {
        WebElement result = getElement(FirstResult);
        click(result);
        driverSleep(1000);
    }

    public void accessPoster() throws InterruptedException {
        WebElement poster = getElement(Poster);
        click(poster);
        driverSleep(1000);
    }

    public void backButton() throws InterruptedException {
        navigateBack();
    }

    public void accessVideo(){
        WebElement video = getElement(Video);
        click(video);
    }

    public void runAllScenarious() throws InterruptedException {
        accessImdb();
        searchImdb();
        accessFirstResult();
        accessPoster();
        backButton();
        accessVideo();
    }


}
