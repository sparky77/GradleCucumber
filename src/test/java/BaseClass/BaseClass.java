package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by marcus on 29/04/2018.
 * This below class is BaseClass to be extended by any class using the webDriver.
 * Writting clever custome methods to interact with page, without the need for extras, such as waits - work in progress
 */
public class BaseClass {
    public static final String baseUrl = setBaseUrl();
    public WebDriver driver;
    public final String resourceLocation = "/src/test/resources/";


    public static String setBaseUrl(){
        String baseUrl = "https://www.tesco.com/";
        return baseUrl;
    }

    public WebDriver lauchingDriverType(String driverType){
        File classPathRoot = new File(System.getProperty("user.dir"));
        switch(driverType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", classPathRoot + resourceLocation + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "phantomjs":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, classPathRoot + resourceLocation + "phantomjs.exe");
                driver = new PhantomJSDriver(caps);
                break;
        }
        return driver;
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    // Below is experimental - but working
    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
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
