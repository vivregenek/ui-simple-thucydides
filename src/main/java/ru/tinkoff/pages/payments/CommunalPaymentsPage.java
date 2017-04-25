package ru.tinkoff.pages.payments;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

/**
 * Elements and methods for communal payments page
 * Created by Евгения
 */
@DefaultUrl("https://www.tinkoff.ru/payments/kommunalnie-platezhi/")
public class CommunalPaymentsPage extends PaymentsPage {

    @FindBy(css=".ui-menu__item_icons .ui-menu__logo-link[href='/zhku-moskva/']")
    private WebElement zhkuMoscowItem;

    /**
     * Click on Zhku Moscow
     */
    public void clickZhkuMoscowElement() {
        zhkuMoscowItem.click();
    }
}
