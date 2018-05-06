package Steps;
import HelperClasses.BaseClass;
import HelperClasses.ReadFrom;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static HelperClasses.WebDriver.WebDriverLaucher.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs extends BaseClass{

    String HomePageTitle = ReadFrom.propertiesFile("defaultSetupProperties","TescoHomePageTitle");

   @After
    public void tearDown(){
        System.out.println("Test Completed, quiting WebDrier Instance");
        driver.quit();
    }

    @Test
    @Given("^User Navigaties to Tesco home page$")
    public void userNavigatiesToHomePage() throws Throwable {
        startDriver();
        visit(baseUrl);
    }

    @Then("^User clicks on close cookie policy button")
    public void userClicksCloseCookiePoliceButton(){
        click(By.className("announcement-close-icon"));
    }


    @Then("^Check the homePage title is as expected$")
    public void getAndComparePageTitle(){
        //System.out.println(HomePageTitle);
        // TODO will implement HomePage obj here as POC
        assertTrue("Page title not as defined expected result"+driver.getTitle(),HomePageTitle.equals(driver.getTitle()));
    }

    private void waitForClickableElementAndClick(String elementName) {
        WebElement clickableElement = find(By.className(elementName)); // "announcement-close-icon"
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(clickableElement)).click();
    }

    @Test
    @Given("^Test to return the HTTP responce of the server$")
    public void RequestHTTPResponceCode() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Getting HTTP responce code method");
        System.out.println(getResponseCode(baseUrl));
    }

    @Given("^User enters correct password details$")
    public void user_enters_correct_password_details() throws Throwable {
        System.out.println("User enters correct password details method");
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^User clicks the login button$")
    public void user_clicks_the_login_button() throws Throwable {
        System.out.println("User Clicks login button method");
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^User is succesfully logged in$")
    public void user_is_succesfully_logged_in() throws Throwable {
        System.out.println("User is successfully logged in method.. ");
    }

}
