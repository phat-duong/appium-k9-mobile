package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.List;

public class XpathLearning {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to Login screen
            MobileElement navLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtn.click();

            //Find all matching elements
            List<MobileElement> credFieldsElem = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credFieldsElem.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credFieldsElem.get(PASSWORD_INDEX).sendKeys("12345678");

            //Find login info text by UISelector
            MobileElement loginInstructorElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructorElem.getText());

            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
