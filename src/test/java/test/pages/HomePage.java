package test.pages;

import org.openqa.selenium.By;
import utilities.PageHelper;

public class HomePage extends PageHelper {
    public HomePage() {
        super();
    }


    By continueWithoutLoginButton = By.id("com.akakce.akakce:id/continueWithoutRegister");
    By searchBox = By.id("com.akakce.akakce:id/searchTextView");
    By secondSearchBox = By.xpath("//*[@resource-id='com.akakce.akakce:id/searchTextView' and ./parent::*[./parent::*[@resource-id='com.akakce.akakce:id/search_fragment_header']]]");

    public void continueWithoutLogin() {
        waitAndClick(continueWithoutLoginButton);
    }

    public void searchProduct(String query) {
        waitAndClick(searchBox);
        sendKey(secondSearchBox, query);
        sendEnterKey();
    }
}
