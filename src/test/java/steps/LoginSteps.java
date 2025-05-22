package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {


    @When("user enters {string} and {string} and verify the {string}")
    public void user_enters_and_and_verify_the(String username, String password, String errorMsg) {
        sendText(username,loginPage.usernameField);
        sendText(password,loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String usr, String pasw) {
        sendText(usr,loginPage.usernameField);
        sendText(pasw, loginPage.passwordField);
    }

    @Then("the user is logged in and the dashboard message is displayed")
    public void the_user_is_logged_in_and_the_dashboard_message_is_displayed() {
        Assert.assertEquals(dashboardPage.dashboard.getText(),"Welcome Admin");
    }









}
