package ru.tinkoff.steps.payments;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.tinkoff.pages.payments.PaymentsPage;

import static org.junit.Assert.assertTrue;

/**
 * Class with end user steps for payments page
 * Created by Евгения
 */
public class PaymentsSteps extends ScenarioSteps {

    PaymentsPage paymentsPage;

    // !!!!!!!!!! скрепя сердцем делаю так, объяснение в письме
    private final String paymentsType = "Платежи";

    /**
     * Check that payments page opened
     */
    @Step
    public void paymentsPageShouldBeOpened() {
        assertTrue("Payments page was not opened.", paymentsPage.isSomePaymentsPageOpened(paymentsType));
    }

    /**
     * Click on Communal payments item
     */
    @Step
    public void clickCommunalPayments() {
        paymentsPage.clickCommunalPaymentsItem();
    }
}
