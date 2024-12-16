package test.stepDefinitions;

import io.cucumber.java.en.*;
import test.pages.SearchPage;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @And("User applies filter for category {string}")
    public void user_applies_filter_for_category(String category) {
        searchPage.applyFilter();
    }

    @And("User selects sorting by {string}")
    public void user_selects_sorting_by(String sortingOption) {
        searchPage.sortByHighestPrice();
    }

    @And("User selects the {int}th product from the list and go to product")
    public void user_selects_the_th_product_from_the_list_and_go_to_product(int productIndex) {
        searchPage.selectProduct(productIndex);
    }
}
