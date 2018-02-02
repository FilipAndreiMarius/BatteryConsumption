package PageObjects;

import Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static PageObjConstants.Constants.WIKI_URL;
import static PageObjConstants.Constants.WIKI_SEARCH;

/**
 * Created by ionut.budeanu on 1/29/2018.
 */
public class Wikipedia extends BaseObject {

    static By SearchField = By.name("search");
    static By Photo = By.cssSelector("a[href*='/wiki/File:President_Barack_Obama.jpg']");
    static By TalkSection = By.id("ca-talk");

    public Wikipedia(){
        setUp();
    }

    public void accessWiki(){
        navigateToUrl(WIKI_URL);
    }

    public void searchWiki() throws InterruptedException {
        sendKeysAndPressEnter(SearchField, WIKI_SEARCH);
        driverSleep(2000);
    }

    public void accessPhoto(){
        WebElement photo = getElement(Photo);
        click(photo);
    }

    public void goBack() throws InterruptedException {
        navigateBack();
    }

    public void accessTalkSection(){
        WebElement talk = getElement(TalkSection);
        click(talk);
    }

    public void runAllFlows() throws InterruptedException {
        accessWiki();
        searchWiki();
        accessPhoto();
        goBack();
        accessTalkSection();

    }


}
