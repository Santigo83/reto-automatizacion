package com.retotecnico.stepdefinitions;

import com.retotecnico.pages.LoginPage;
import com.retotecnico.pages.PurchasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PurchaseStepDefinitions {

    private static final String PURCHASE_USER_EMAIL = "qa@malineitor.com";
    private static final String PURCHASE_USER_PASSWORD = "123456";

    @Managed(driver = "chrome")
    WebDriver driver;

    LoginPage loginPage;
    PurchasePage purchasePage;

    @Given("que el usuario tiene una cuenta valida e inicia sesion en Demo Web Shop")
    public void queElUsuarioTieneUnaCuentaValidaEIniciaSesionEnDemoWebShop() {
        loginPage = new LoginPage(driver);
        loginPage.logoutIfLoggedIn();
        loginPage.openLoginForm();
        loginPage.login(PURCHASE_USER_EMAIL, PURCHASE_USER_PASSWORD);
    }

    @When("selecciona una categoria y subcategoria, agrega un producto al carrito y completa la compra con tarjeta de credito")
    public void seleccionaUnaCategoriaYSubcategoriaAgregaUnProductoAlCarritoYCompletaLaCompraConTarjetaDeCredito() {
        purchasePage = new PurchasePage(driver);
        purchasePage.navigateToProduct();
        purchasePage.addProductToCart();
        purchasePage.openCart();
        purchasePage.proceedToCheckout();
        purchasePage.completeBillingAddress("Colombia", "Bogota", "Calle 100 #10-20", "110111", "3001234567");
        purchasePage.continueShippingAddressIfRequired();
        purchasePage.continueShippingMethod();
        purchasePage.selectCreditCardPaymentMethod();
        purchasePage.completePaymentInformation();
        purchasePage.confirmOrder();
    }

    @Then("deberia visualizar el mensaje Your order has been successfully processed!")
    public void deberiaVisualizarElMensajeYourOrderHasBeenSuccessfullyProcessed() {
        Assert.assertEquals("Your order has been successfully processed!", purchasePage.getOrderSuccessMessage());
    }
}
