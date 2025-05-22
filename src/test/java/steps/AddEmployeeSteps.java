package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeSteps extends CommonMethods {


    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        Assert.assertEquals(dashboardPage.dashboard.getText(),"Welcome Admin");
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOption);
    }

    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters firstname {string} and lastname {string}")
    public void user_enters_firstname_and_lastname(String firstName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameLocator);
        sendText(lastName, addEmployeePage.lastNameLocator);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("the system should generate a unique employee ID")
    public void the_system_should_generate_a_unique_employee_id() {
        Assert.assertTrue(addEmployeePage.employeeId.isDisplayed());

    }

    @Then("the employee should be added successfully")
    public void the_employee_should_be_added_successfully() {
        Assert.assertTrue(addEmployeePage.employeeId.isDisplayed());
    }

    @Then("user providing a unique employee ID")
    public void user_providing_a_unique_employee_id() {
        String empId = generateUniqueEmployeeId();
        sendText(empId,addEmployeePage.addEmpId);
    }



    @When("user enters incomplete or invalid information")
    public void user_enters_incomplete_or_invalid_information() {
        sendText(" ", addEmployeePage.firstNameLocator);
        sendText("Rogers", addEmployeePage.lastNameLocator);

    }

    @Then("user can see the error message Required")
    public void user_can_see_the_error_message_required() {
        Assert.assertTrue(addEmployeePage.firstNameError.isDisplayed());
    }

}
