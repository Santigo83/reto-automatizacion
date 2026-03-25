package com.retotecnico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    // Prioridad aplicada: class para el enlace porque no tiene id ni name.
    private static final By REGISTER_LINK = By.className("ico-register");

    // Prioridad aplicada: id para los campos del formulario y boton de registro.
    private static final By GENDER_MALE_RADIO_BUTTON = By.id("gender-male");
    private static final By GENDER_FEMALE_RADIO_BUTTON = By.id("gender-female");
    private static final By FIRST_NAME_INPUT = By.id("FirstName");
    private static final By LAST_NAME_INPUT = By.id("LastName");
    private static final By EMAIL_INPUT = By.id("Email");
    private static final By PASSWORD_INPUT = By.id("Password");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("ConfirmPassword");
    private static final By REGISTER_BUTTON = By.id("register-button");

    // Prioridad aplicada: class porque el mensaje no expone id ni name.
    private static final By REGISTRATION_RESULT_MESSAGE = By.className("result");

    public RegisterPage() {
    }

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationForm() {
        open();
        $(REGISTER_LINK).click();
    }

    public void registerUser(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        selectGender(gender);
        $(FIRST_NAME_INPUT).type(firstName);
        $(LAST_NAME_INPUT).type(lastName);
        $(EMAIL_INPUT).type(email);
        $(PASSWORD_INPUT).type(password);
        $(CONFIRM_PASSWORD_INPUT).type(confirmPassword);
        $(REGISTER_BUTTON).click();
    }

    public String getRegistrationResultMessage() {
        return $(REGISTRATION_RESULT_MESSAGE).getText();
    }

    private void selectGender(String gender) {
        if ("F".equalsIgnoreCase(gender)) {
            $(GENDER_FEMALE_RADIO_BUTTON).click();
            return;
        }
        $(GENDER_MALE_RADIO_BUTTON).click();
    }
}
