package org.mozilla.battery.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.mozilla.battery.PageObjConstants.Constants;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverInstance {

    private static final Logger logger = LogManager.getLogger(DriverInstance.class.getName());
    private static WebDriver instance = null;


    public static WebDriver getInstance(){
        if(instance == null){
            logger.info("Initializing driver...");
            System.setProperty(Constants.WEBDRIVER_PROPERTY,Constants.WEBDRIVER_PATH);
            instance = new FirefoxDriver();
            instance.manage().window().maximize();
        }
        logger.info("Driver initialized");
        return instance;
    }

}
