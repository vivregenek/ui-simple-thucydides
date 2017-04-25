package ru.tinkoff.pages.payments.communalproviders;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.tinkoff.pages.BasePage;

/**
 * Elements and methods for Zhku Moscow page
 * Created by Евгения
 */
@DefaultUrl("https://www.tinkoff.ru/zhku-moskva/")
public class ZhkuMoscowPage extends BasePage {

    @FindBy(xpath="//*[contains(@class,'ui-header-banner__logo')]//*[contains(@style,'zhku-moskva.png')]")
    private WebElement zhkuMoscowLogo;
    @FindBy(css=".ui-menu-second__link[href~='/zhku-moskva/oplata/']")
    private WebElement payTabElement;
    @FindBy(css=".ui-menu-second__link_active[href~='/zhku-moskva/oplata/']")
    private WebElement activePayTab;
    @FindBy(css="#payerCode")
    private WebElement payerCodeInput;
    @FindBy(css=".ui-input_error #payerCode")
    private WebElement payerCodeWithErrorElement;
    @FindBy(xpath="//*[@id='payerCode']/ancestor::*[contains(@class,'ui-form__field')]//*[contains(@class,'ui-form-field-error-message')]")
    private WebElement errorForPayerCodeElement;

    /**
     * Check that Zhku Moscow page opened
     * @return boolean
     */
    public boolean isZhkuMoscowPageOpened() {
        return waitForElementPresent(zhkuMoscowLogo);
    }

    /**
     * Click payment tab
     */
    public void clickOnPaymentTab() {
        payTabElement.click();
    }

    /**
     * Check that pay tab active
     * @return boolean
     */
    public boolean isPayTabActive() {
        return waitForElementPresent(activePayTab);
    }

    /**
     * Type text to payer code input
     * @param text
     */
    public void typeTextAndEnterToPayerCodeInput(String text) {
        $(payerCodeInput).type(text);
        $(payerCodeInput).sendKeys(Keys.ENTER);
    }

    /**
     * Check that payer code field with error
     * @return boolean
     */
    public boolean isPayerCodeWithError() {
        return waitForElementPresent(payerCodeWithErrorElement);
    }

    /**
     * Check that error for payer code tab present
     * @return boolean
     */
    public boolean isErrorForPayerCodeFieldPresent() {
        return waitForElementPresent(errorForPayerCodeElement);
    }

    /**
     * Get text error for payer code field
     * @return String
     */
    public String getErrorForPayerCodeText() {
        return errorForPayerCodeElement.getText();
    }
}
