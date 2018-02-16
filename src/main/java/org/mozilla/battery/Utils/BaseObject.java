package org.mozilla.battery.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by ionut.budeanu on 1/22/2018.
 */
public class BaseObject {

    private static int timeout = 10;
    public static WebDriver driver;
    public WebDriverWait wait;

    public BaseObject(){
        driver = DriverInstance.getInstance();
        PageFactory.initElements(driver,this);
        driverSleep(1000);
    }


    public void navigateToUrl(String Url) {
        driver.navigate().to(Url);
    }

    public void navigateBack() {
        driver.navigate().back();
        driverSleep(2000);
    }

    public WebElement getElement(By selector) {
        waitForElementToBeVisible(selector);
        return driver.findElement(selector);

    }

    public List<WebElement> getElements(By selector) {
        waitForElementToBeVisible(selector);
        return driver.findElements(selector);
    }


    public void click(WebElement locator) {
        waitForElementToBeClickable(locator);
        locator.click();
    }

    public void click(By selector) {
        WebElement element = getElement(selector);
        element.click();
    }

    public void sendKeys(WebElement locator, String value) {
        locator.sendKeys(value);
        locator.click();
    }


    public void sendKeysAndPressEnter(WebElement locator, String value) {
        locator.sendKeys(value);
        locator.sendKeys(Keys.ENTER);
    }


    public void waitForElementToBeVisible(By element) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void driverSleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeAllTabsExceptFirst() {
        try {
            int numberOfTabs = driver.getWindowHandles().size();
            if (numberOfTabs > 1) {
                for (int i = numberOfTabs - 1; i > 0; i--) {
                    String winHandle = driver.getWindowHandles().toArray()[i].toString();
                    driver.switchTo().window(winHandle);
                    driver.close();
                }
                driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }


}




