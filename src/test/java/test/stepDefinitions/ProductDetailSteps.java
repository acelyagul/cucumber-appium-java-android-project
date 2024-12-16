package test.stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import test.pages.ProductDetailPage;

public class ProductDetailSteps {
    ProductDetailPage productDetailPage = new ProductDetailPage();


    @Then("Verify {string} button is visible on the product details page")
    public void verify_button_is_visible_on_the_product_details_page(String buttonName) {
        boolean isVisible = productDetailPage.isSellerButtonVisible();
        Assert.assertTrue(isVisible);
    }
}
