package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;
import java.util.List;

public class SwipeVertically {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to Forms screen
            MobileElement navFormsScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsScreenBtn.click();

            //Wait until user is on Forms screen
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form components\")")));

            //Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            //Calculate touch points
            int xStartPoint = 50 * screenWidth/100;
            int xEndPoint = 50 * screenWidth/100;

            int yStartPoint = 50 * screenHeight/100;
            int yEndPoint = 10 * screenHeight/100;

            //Convert coordinate -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            //Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            //Swipe down
            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();

            //Find all elements
            MobileElement inputFieldElem = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement switchButtonElem = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement switchTextElem = appiumDriver.findElement(MobileBy.AccessibilityId("switch-text"));
            MobileElement dropdownElem = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));

            //Input text into elements
            inputFieldElem.sendKeys("appium");
            switchButtonElem.click();
            System.out.println(switchTextElem.getText());
            dropdownElem.click();

            //Choose appium option
            MobileElement appiumOptionElem = appiumDriver.findElement(MobileBy.id("android:id/text1"));
            appiumOptionElem.click();


            //Click on button active
            MobileElement activeButtonElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeButtonElem.click();
            MobileElement activeDialogMessage = appiumDriver.findElement(MobileBy.id("android:id/message"));
            System.out.println(activeDialogMessage.getText());

            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
