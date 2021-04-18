package pages;

import base.DriverHolder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import waiter.WaitCondition;

import java.io.File;

public class ContactUsPage {

    private static final By TEXT_AREA = By.cssSelector("textarea[id='message']");

    private static final String MESSAGE = "This is message for your service.";

    private static final By UPLOAD_FIELD = By.cssSelector("input[id='fileUpload']");

    private static final By SEND_BUTTON = By.cssSelector("button[id='submitMessage']");

    private static final String CHECK_MESSAGE = "Your message has been successfully sent to our team.";

    private static final By ALERT_MESSAGE = By.cssSelector("p[class='alert alert-success']");

    private static final String GREEN_COLOR = "rgba(85, 198, 94, 1)";

    private static final File UPLOAD_FILE = new File("src/main/resources/arrow.png");

    public ContactUsPage fillingContactUsData() {
        selectSubjectHeading(SubjectHeading.CUSTOMER_SERVICE);
        attachFile();
        enterMessage();

        return this;
    }

    private ContactUsPage selectSubjectHeading(final SubjectHeading subjectHeading) {
        final Select select = new Select(DriverHolder.getDriverThread().findElement(By.cssSelector("select[id='id_contact']")));
        select.selectByVisibleText(subjectHeading.getSubjectHeading());

        return this;
    }

    private ContactUsPage attachFile() {
        final WebElement webElement = DriverHolder.getDriverThread().findElement(UPLOAD_FIELD);
        webElement.sendKeys(UPLOAD_FILE.getAbsolutePath());

        return this;
    }

    private ContactUsPage enterMessage() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(TEXT_AREA).sendKeys(MESSAGE);

        return this;
    }

    public ContactUsPage clickSendButton() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SEND_BUTTON).click();
        return this;
    }

    public ContactUsPage checkThatSendMessageIsSuccess() {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(ALERT_MESSAGE).getText(), CHECK_MESSAGE);
        Assert.assertTrue(waitCondition.waitForVisibilityOfElementLocatedBy(ALERT_MESSAGE).getCssValue("background-color").contains(GREEN_COLOR));

        return this;
    }
}
