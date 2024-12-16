package test.pages;

import org.openqa.selenium.By;
import utilities.PageHelper;

public class SearchPage extends PageHelper {
    public SearchPage() {
        super();
    }

    By filterButton = By.id("com.akakce.akakce:id/filterArea");
    By categoryOption = By.xpath("//*[@text='Bilgisayar, Donanım']");
    By applyFilterButton = By.id("com.akakce.akakce:id/applyFilterTextView");
    By sortOptionsButton = By.id("com.akakce.akakce:id/sortText");
    By sortOptionHighestPrice = By.xpath("//*[@text='En Yüksek Fiyat']");
    By goToProductButton = By.id("com.akakce.akakce:id/detailBtnTextView");


    public void applyFilter() {
        waitAndClick(filterButton);
        waitAndClick(categoryOption);
        waitAndClick(applyFilterButton);
    }

    public void sortByHighestPrice() {
        waitAndClick(sortOptionsButton);
        waitAndClick(sortOptionHighestPrice);
    }

    public void selectProduct(int index) {
        By productItem = By.xpath("(//*[@resource-id='com.akakce.akakce:id/cellContainer'])[" + index + "]");
        scrollUntilElement(productItem);
        waitAndClick(productItem);
        waitAndClick(goToProductButton);
    }
}
