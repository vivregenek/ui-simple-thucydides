package ru.tinkoff.steps.payments.communalproviders;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.tinkoff.pages.payments.communalproviders.ZhkuMoscowPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class with end user steps for communal Zhkou Moscow page
 * Created by Евгения
 */
public class ZhkuMoscowSteps extends ScenarioSteps{

    ZhkuMoscowPage zhkuMoscowPage;

    private final String invalidValueErrorForPayerCodeText = "";
    private final String emptyValueErrorForPayerCodeText = "";


    /**
     * Check that Zhku Moscow page opened
     */
    @Step
    public void zhkuMoscowPageShouldBeOpened() {
        assertTrue("Zhku Moscow page was not opened.", zhkuMoscowPage.isZhkuMoscowPageOpened());
    }

    /**
     * Click payment tab
     */
    @Step
    public void clickOnPaymentTab() {
        zhkuMoscowPage.clickOnPaymentTab();
    }

    /**
     * Pay tab should be active
     * @return boolean
     */
    @Step
    public void payTabShouldBeActive() {
        assertTrue("Pay tab is not active.", zhkuMoscowPage.isPayTabActive());
    }

    /**
     * Type text to payer code field
     * @param text
     */
    @Step
    public void typeTextAndEnterToPayerCode(String text) {
        zhkuMoscowPage.typeTextAndEnterToPayerCodeInput(text);
    }

    /**
     * Check that payer code field with error
     */
    @Step
    public void payerCodeShouldBeWithError() {
       assertTrue("Pay tab without error.", zhkuMoscowPage.isPayerCodeWithError());
    }

    /**
     * Check that error for pay tab present
     */
    @Step
    public void errorForPayerCodePresent(String expectedErrorText) {
        assertTrue("Error for pay tab not present.", zhkuMoscowPage.isErrorForPayerCodeFieldPresent());
        String actualTextValue = zhkuMoscowPage.getErrorForPayerCodeText();
        assertEquals("Error for pay tab not equal expected value.", expectedErrorText, actualTextValue);
    }
}
