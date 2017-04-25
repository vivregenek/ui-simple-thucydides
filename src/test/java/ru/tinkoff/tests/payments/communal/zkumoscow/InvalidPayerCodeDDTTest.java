package ru.tinkoff.tests.payments.communal.zkumoscow;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.tinkoff.requirements.Application;
import ru.tinkoff.steps.payments.CommunalPaymentsSteps;
import ru.tinkoff.steps.payments.communalproviders.ZhkuMoscowSteps;

import java.util.Arrays;
import java.util.Collection;

/**
 * Check invalid values for payer code field
 * Created by Евгения
 */
@Concurrent(threads="5")
@Story(Application.Payments.CommunalPayments.ZkuMoscow.InvalidPayerCodeDDT.class)
@RunWith(ThucydidesParameterizedRunner.class)
public class InvalidPayerCodeDDTTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages()
    public Pages pages;

    @Steps
    public CommunalPaymentsSteps communalPaymentsSteps;
    @Steps
    public ZhkuMoscowSteps zhkuMoscowSteps;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"0", "Поле неправильно заполнено"},
                {"123456789", "Поле неправильно заполнено"},
                {"!@#$%^&*()", "Поле неправильно заполнено"},
                {"dddddddddd", "Поле неправильно заполнено"},
                {"", "Поле обязательное"}
        });
    }

    private String value;
    private String errorText;

    public InvalidPayerCodeDDTTest(String value, String errorText)
        {
            this.value = value;
            this.errorText = errorText;
        }

    @Test
    public void invalid_payer_code_ddt_test() {

        // open communal page
        communalPaymentsSteps.openCommunalPsymentsPage();
        communalPaymentsSteps.communalPaymentsPageShouldBeOpened();

        // open Zhku Moscow
        communalPaymentsSteps.clickZhkuMoscow();
        zhkuMoscowSteps.zhkuMoscowPageShouldBeOpened();

        // open pay tab
        zhkuMoscowSteps.clickOnPaymentTab();
        zhkuMoscowSteps.payTabShouldBeActive();

        // type invalid value to payer code field
        zhkuMoscowSteps.typeTextAndEnterToPayerCode(value);

        // check error
        zhkuMoscowSteps.payerCodeShouldBeWithError();
        zhkuMoscowSteps.errorForPayerCodePresent(errorText);
    }
}
