package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.util.List;

public class PageHelper {
    protected AppiumDriver<MobileElement> driver = ThreadLocalDriver.getTLDriver();
    protected WebDriverWait wait;

    public PageHelper() {
        wait = new WebDriverWait(driver, 15);
    }

    protected void waitAndClick(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void hideKeyboard() {
        driver.navigate().back();
    }

    protected List<WebElement> waitAndFindElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendKey(By by, String text) {
        waitAndFindElement(by).sendKeys(text);
    }


    protected void scrollDown() {
        int scrollStart = (int) (driver.manage().window().getSize().height * 0.8);
        int scrollEnd = (int) (driver.manage().window().getSize().height * 0.2);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(0, scrollStart))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }

    protected void scrollUntilElement(By by) {
        while (driver.findElements(by).size() == 0) {
            scrollDown();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void sendEnterKey() {
        try {
            if (driver instanceof AndroidDriver) {
                // Android cihazlar için ENTER tuşunu simüle et
                ((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            } else {
                // Diğer platformlar için aktif elemana ENTER tuşu gönder
                WebElement activeElement = driver.switchTo().activeElement();
                activeElement.sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            System.out.println("Failed to send ENTER key: " + e.getMessage());
            e.printStackTrace();
        }
    }

}



