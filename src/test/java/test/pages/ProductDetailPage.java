package test.pages;

import org.openqa.selenium.By;
import utilities.PageHelper;

public class ProductDetailPage extends PageHelper {
    public ProductDetailPage() {
        super();
    }

    By goToSellerButton = By.xpath("//*[@text='Satıcıya Git']");

    public boolean isSellerButtonVisible() {
        return waitAndFindElement(goToSellerButton).isDisplayed();
    }

}
