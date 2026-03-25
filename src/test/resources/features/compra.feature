Feature: Compra de productos Demo Web Shop

  Scenario: Comprar un producto con un usuario registrado
    Given que el usuario tiene una cuenta valida e inicia sesion en Demo Web Shop
    When selecciona una categoria y subcategoria, agrega un producto al carrito y completa la compra con tarjeta de credito
    Then deberia visualizar el mensaje Your order has been successfully processed!
