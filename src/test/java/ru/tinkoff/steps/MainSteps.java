package ru.tinkoff.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.tinkoff.pages.MainPage;
import static org.junit.Assert.*;

/**
 * Class with end user steps for main page
 * Created by Евгения
 */
public class MainSteps extends ScenarioSteps {

    MainPage mainPage;

    /**
     * Open main page
     */
    @Step
    public void openMainPage() {
        mainPage.open();
    }

    /**
     * Check that main page opened
     */
    @Step
    public void mainPageShouldBeOpened() {
        assertTrue("Main page was not opened.", mainPage.isMainPageOpened());
    }

    /**
     * Click on Payments item
     */
    @Step
    public void clickPayments() {
        mainPage.clickPaymentsItem();
    }
}
