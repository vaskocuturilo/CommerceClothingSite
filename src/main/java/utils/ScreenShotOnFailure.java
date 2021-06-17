package utils;

import base.DriverHolder;
import io.qameta.allure.Attachment;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotOnFailure implements MethodRule {
    @Override
    public Statement apply(Statement statement, FrameworkMethod method, Object object) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (RuntimeException throwable) {
                    makeScreenshotOnFailure();
                    throw throwable;
                }
            }

            @Attachment("Screenshot on failure")
            public byte[] makeScreenshotOnFailure() {
                return ((TakesScreenshot) DriverHolder.getDriverThread()).getScreenshotAs(OutputType.BYTES);
            }
        };
    }
}
