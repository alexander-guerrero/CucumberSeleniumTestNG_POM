package org.example.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.utils.HelperClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public static void setUp() {
        HelperClass.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {
//        Validate if scenario has failed
        if (scenario.isFailed()) {
//            var foo = (TakesScreenshot) HelperClass.getDriver();
//            var bar = foo.getScreenshotAs(OutputType.BYTES);
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        HelperClass.tearDown();
    }

}
