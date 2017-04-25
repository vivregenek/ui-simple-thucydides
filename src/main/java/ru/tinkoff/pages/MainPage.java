package ru.tinkoff.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

/**
 * Elements and methods for main page
 * Created by Евгения
 */
@DefaultUrl("https://www.tinkoff.ru/")
public class MainPage extends BasePage{

    @FindBy(css=".ui-menu-primary_main-page")
    private WebElementFacade mainMenuElement;
    @FindBy(css=".ui-menu-primary__item_main-page .ui-link[href~='/payments/']")
    private WebElementFacade paymentsElement;


    /**
     * Check that main page opened
     * @return boolean
     */
    public boolean isMainPageOpened() {
        return waitForElementPresent(mainMenuElement);
    }

    /**
     * Click on Payments item
     */
    public void clickPaymentsItem(){
        paymentsElement.click();
    }
}
