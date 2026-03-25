package com.retotecnico.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        super(driver);
    }

    protected void type(By locator, String value) {
        $(locator).waitUntilVisible().clear();
        $(locator).type(value);
    }

    protected void click(By locator) {
        $(locator).waitUntilClickable().click();
    }

    protected void selectByVisibleText(By locator, String value) {
        $(locator).waitUntilVisible().selectByVisibleText(value);
    }

    protected boolean isVisible(By locator) {
        return containsElements(locator) && $(locator).isVisible();
    }

    protected void clickIfVisible(By locator) {
        if (isVisible(locator)) {
            click(locator);
        }
    }

    protected String readText(By locator) {
        return $(locator).waitUntilVisible().getText();
    }

    protected WebElementFacade findVisibleElement(By locator) {
        return $(locator).waitUntilVisible();
    }

    protected void dismissBrowserPopupIfPresent() {
        try {
            Robot robot = new Robot();
            waitABit(1000);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            waitABit(500);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException ignored) {
        }
    }
}
