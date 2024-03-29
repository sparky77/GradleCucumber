package HelperClasses;

import HelperClasses.WebDriver.WebDriverLaucher;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static HelperClasses.WebDriver.WebDriverLaucher.driver;

/**
 * Created by marcus on 29/04/2018.
 * This below class is HelperClasses to be extended by any class using the webDriver.
 * Writting clever custome methods to interact with page, without the need for extras, such as waits - work in progress
 */
public class BaseClass {

    public String baseUrl = setBaseUrl();
    public WebDriverLaucher driverLauncher;

    public static String setBaseUrl(){
        String baseUrl = ReadFrom.propertiesFile("defaultSetupProperties","url");
        return baseUrl;
    }

    public void startDriver(){
       driverLauncher = new WebDriverLaucher();
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    // Below is experimental - but working with intergrated fluent wait
    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Untested
    public void type(String inputText,By locator){
        find(locator).sendKeys(inputText);
    }

    // Untested
    public void submit(By locator){
        find(locator).submit();
    }

    public Boolean isDisplayed(By locator){
        try {
            return find(locator).isDisplayed();
        }catch(NoSuchElementException exception){
            return false;
        }
    }

   // Method to get status code - assert 200 :: Experimental but working
    public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        return huc.getResponseCode();
    }
}
