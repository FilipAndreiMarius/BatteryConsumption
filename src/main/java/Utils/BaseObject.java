package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Commons\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }



    public void navigateToUrl(String Url){
        driver.navigate().to(Url);
    }

    public void navigateBack() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
    }

    public WebElement getElement(By selector){
        waitForElementToBeVisible(selector);
        return driver.findElement(selector);

    }

    public List<WebElement> getElements(By selector){
        waitForElementToBeVisible(selector);
        return driver.findElements(selector);
    }


    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public void click(By selector){
        WebElement element = getElement(selector);
        element.click();
    }

    public void sendKeys(By selector, String value){
        WebElement element = getElement(selector);
        element.sendKeys(value);
        element.click();
    }


    public void sendKeysAndPressEnter(By selector, String value){
        WebElement element = getElement(selector);
        element.sendKeys(value);
        Actions actions = new Actions(driver);
        actions.sendKeys(element, Keys.ENTER).build().perform();
    }


    public void waitForElementToBeVisible(By element){
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait = new WebDriverWait(driver , timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void driverSleep(final long millis) throws InterruptedException {
        Thread.sleep(millis);
    }







}




