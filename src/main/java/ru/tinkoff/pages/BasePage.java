package ru.tinkoff.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Page which contains common methods for all pages
 * Created by Евгения
 */
public class BasePage extends PageObject {

    /**
     * Wait some condition
     * @param expectedConditions condition, which will wait
     * @param timeOutInSeconds max wait time
     * @return
     */
    private boolean waitForCondition(ExpectedCondition expectedConditions, int timeOutInSeconds) {
        boolean result = true;
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds, 500);
        try {
            wait.until(expectedConditions);
        } catch (NoSuchElementException | TimeoutException exception) {
            result = false;
        } catch (StaleElementReferenceException exception) {
        } catch (Throwable t) {
            throw new Error(t);
        }
        return result;
    }

    /**
     * Wait when element will present on the DOM and visible
     * @param webElement element, which should be present
     * @return boolean
     */
    public boolean waitForElementPresent(WebElement webElement){
        return waitForCondition(ExpectedConditions.visibilityOf(webElement), 10);
    }

    /**
     * Wait when element will present on the DOM and visible
     * @param webElement element, which should be present
     * @return boolean
     */
    public boolean waitForTextPresentInElement(WebElement webElement, String text){
        return waitForCondition(ExpectedConditions.textToBePresentInElement(webElement, text), 10);
    }

    /**
     * Scroll page to element and wait when it will clickable
     * @param webElement element to scroll
     */
    public void scrollAndWaitToElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15, 500);
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Throwable t) {
            throw new Error(t);
        }
    }
}
