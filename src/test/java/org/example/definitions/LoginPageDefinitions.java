package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.HomePageActions;
import org.example.actions.LoginPageActions;
import org.example.utils.HelperClass;
import org.testng.Assert;

public class LoginPageDefinitions {

    LoginPageActions objLoginPage = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();

    @Given("User is on HRM Login page {string}")
    public void loginTest(String url) {
        HelperClass.openPage(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String password) {
//        Login to application
        objLoginPage.login(userName, password);
//        Go to the next page
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
//        Verify home page
        Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
//        Verify error message
        Assert.assertEquals(objLoginPage.getErrorMessage(), expectedErrorMessage);
    }

    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
        Assert.assertEquals(objLoginPage.getMissingUsernameText(), message);
    }

}
