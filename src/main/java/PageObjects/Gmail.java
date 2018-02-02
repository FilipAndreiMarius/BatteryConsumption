package PageObjects;

import Utils.BaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.util.Password;


import static PageObjConstants.Constants.GMAIL_URL;
import static PageObjConstants.Constants.GMAIL_PASSWORD;
import static PageObjConstants.Constants.GMAIL_USERNAME;

/**
 * Created by ionut.budeanu on 1/29/2018.
 */
public class Gmail extends BaseObject {

    static By EmailField = By.id("identifierId");
    static By PasswordField = By.name("password");
    static By EmailNext = By.id("identifierNext");
    static By PasswordNext = By.id("passwordNext");




    public Gmail(){
        setUp();
    }

    public void accessGmail(){
        navigateToUrl(GMAIL_URL);
    }

    public void logIn() throws InterruptedException {
        sendKeys(EmailField, GMAIL_USERNAME);
        WebElement next = getElement(EmailNext);
        click(next);
        driverSleep(1000);
        sendKeys(PasswordField, GMAIL_PASSWORD);
        WebElement nextPass = getElement(PasswordNext);
        click(nextPass);
    }


    public static void main(String[] args) throws InterruptedException {
        Gmail g = new Gmail();
        g.accessGmail();
        g.logIn();
    }

}
