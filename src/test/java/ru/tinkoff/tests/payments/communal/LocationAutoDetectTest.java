package ru.tinkoff.tests.payments.communal;

import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.tinkoff.requirements.Application;
import ru.tinkoff.steps.payments.CommunalPaymentsSteps;
import ru.tinkoff.steps.MainSteps;
import ru.tinkoff.steps.payments.PaymentsSteps;

/**
 * Check location auto detect
 * Created by Евгения
 */
@Story(Application.Payments.CommunalPayments.LocationAutoDetectTest.class)
@RunWith(ThucydidesRunner.class)
public class LocationAutoDetectTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages()
    public Pages pages;

    @Steps
    public MainSteps mainSteps;
    @Steps
    public PaymentsSteps paymentsSteps;
    @Steps
    public CommunalPaymentsSteps communalPaymentsSteps;

    @Test
    public void location_auto_detect_test() {
        // open main page
        mainSteps.openMainPage();
        mainSteps.mainPageShouldBeOpened();

        // open "Payments" page
        mainSteps.clickPayments();
        paymentsSteps.paymentsPageShouldBeOpened();

        // click to Communal Payments
        paymentsSteps.clickCommunalPayments();
        communalPaymentsSteps.communalPaymentsPageShouldBeOpened();

        // check location
        communalPaymentsSteps.locationShouldBePresent("Москве");
    }
}
