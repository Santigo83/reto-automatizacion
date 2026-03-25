package com.retotecnico.stepdefinitions;

import com.retotecnico.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Instant;

public class RegisterStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    RegisterPage registerPage;

    @Given("que el usuario accede al formulario de registro e ingresa datos correctos")
    public void queElUsuarioAccedeAlFormularioDeRegistroEIngresaDatosCorrectos() {
        String registeredEmail = "qa.retotecnico+" + Instant.now().toEpochMilli() + "@mailinator.com";
        String registeredPassword = "Clave123";

        registerPage = new RegisterPage(driver);
        registerPage.openRegistrationForm();
        registerPage.registerUser(
                "M",
                "Carlos",
                "Prueba",
                registeredEmail,
                registeredPassword,
                registeredPassword
        );
    }

    @Then("deberia completar el registro exitosamente")
    public void deberiaCompletarElRegistroExitosamente() {
        Assert.assertEquals("Your registration completed", registerPage.getRegistrationResultMessage());
    }
}
