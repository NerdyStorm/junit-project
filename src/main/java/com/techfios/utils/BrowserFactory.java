package com.techfios.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    
    private static WebDriver driver;
    private static String url = "http://techfios.com/test/101/";

    public static WebDriver initDriver(){

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.get(url);

        return driver;

    }


}
