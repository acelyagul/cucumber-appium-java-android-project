package test.stepDefinitions;

import io.cucumber.java.en.*;
import test.pages.HomePage;


public class HomeSteps {
    HomePage homePage = new HomePage();

    @And("User chooses to continue without login")
    public void user_chooses_to_continue_without_login() {
        homePage.continueWithoutLogin();
    }

    @When("User searches for {string}")
    public void user_searches_for(String query) {
        homePage.searchProduct(query);
    }
}
