package ru.tinkoff.pages.payments;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import ru.tinkoff.pages.BasePage;

/**
 * Elements and methods for payments page
 * Created by Евгения
 */
@DefaultUrl("https://www.tinkoff.ru/payments/")
public class PaymentsPage extends BasePage {

    @FindBy(css=".payment-page__header .payment-page__title")
    private WebElement paymentsHeaderElement;
    @FindBy(css=".ui-menu__logo-link[href='/payments/kommunalnie-platezhi/']")
    private WebElement communalPaymentsElement;
    @FindBy(css=".payment-page__title .payment-page__title_inner")
    private WebElement paymentsLocationElement;

    /**
     * Check that payments page opened
     * @return boolean
     */
    public boolean isSomePaymentsPageOpened(String paymentsType) {
        return waitForTextPresentInElement(paymentsHeaderElement, paymentsType);
    }

    /**
     * Check that payments page opened
     * @return boolean
     */
    public boolean isLocationPresent(String location) {
        return waitForTextPresentInElement(paymentsLocationElement, location);
    }

    /**
     * Click on Communal payments item
     */
    public void clickCommunalPaymentsItem(){
        communalPaymentsElement.click();
    }
}
