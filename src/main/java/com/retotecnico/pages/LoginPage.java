package com.retotecnico.pages;

import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://demowebshop.tricentis.com/")
public class LoginPage extends BasePage {

    private static final By LOGIN_LINK = By.className("ico-login");
    private static final By LOGOUT_LINK = By.className("ico-logout");
    private static final By EMAIL_INPUT = By.id("Email");
    private static final By PASSWORD_INPUT = By.id("Password");
    private static final By LOGIN_BUTTON = By.className("login-button");

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        open();
        click(LOGIN_LINK);
    }

    public void logoutIfLoggedIn() {
        open();
        clickIfVisible(LOGOUT_LINK);
    }

    public void login(String email, String password) {
        type(EMAIL_INPUT, email);
        type(PASSWORD_INPUT, password);
        click(LOGIN_BUTTON);
        dismissBrowserPopupIfPresent();
    }
}
