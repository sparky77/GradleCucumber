package Steps;
import BaseClass.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;


/**
 * Created by marcus on 17/02/2018.
 */

public class MyStepdefs extends BaseClass{

    @Test
    @Given("^User Navigaties to Tesco page$")
    public void userNavigatiesToLoginPage() throws Throwable {
        lauchingDriverType("chrome"); // or phantomjs .. BOOM
        visit(baseUrl); // implemented 'visit' method in Base Class cos why not?
        //checks title
        assertTrue("This is not the title you are looking for Jedi : "+driver.getTitle(),driver.getTitle().contains("Tesco - Online Groceries, Homeware, Electricals & Clothing"));
        click(By.className("announcement-close-icon"));
        driver.quit();
    }

    private void waitForClickableElementAndClick(String elementName) {
        WebElement clickableElement = find(By.className(elementName)); // "announcement-close-icon"
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(clickableElement)).click();
    }

    @Test
    @Given("^Test to return the HTTP responce of the server OH YEAH$")
    public void user_enters_correct_username_deatils() throws Throwable {
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
