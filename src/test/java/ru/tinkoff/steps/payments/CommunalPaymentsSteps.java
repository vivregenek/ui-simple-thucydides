package ru.tinkoff.steps.payments;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.tinkoff.pages.payments.CommunalPaymentsPage;

import static org.junit.Assert.assertTrue;

/**
 * Class with end user steps for communal payments page
 * Created by Евгения
 */
public class CommunalPaymentsSteps extends ScenarioSteps {

    CommunalPaymentsPage communalPaymentsPage;

    private final String paymentsType = "Коммунальные платежи";

    /**
     * Check that communal payments page opened
     */
    @Step
    public void communalPaymentsPageShouldBeOpened(){
        assertTrue("Communal payments page was not opened.", communalPaymentsPage.isSomePaymentsPageOpened(paymentsType));
    }

    /**
     * Check that location present
     */
    @Step
    public void locationShouldBePresent(String location){
        assertTrue(String.format("Location %s was not present.", location), communalPaymentsPage.isLocationPresent(location));
    }

    /**
     * Open communal payments page
     */
    @Step
    public void openCommunalPsymentsPage() {
        communalPaymentsPage.open();
    }

    /**
     * Click on Zhku Moscow
     */
    @Step
    public void clickZhkuMoscow() {
        communalPaymentsPage.clickZhkuMoscowElement();
    }
}
