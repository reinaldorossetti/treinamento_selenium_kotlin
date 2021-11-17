package com.automationpractice.carrinho

import com.automationpractice.core.SeleniumDriver
import com.automationpractice.pages.carrinho.ShoppingCartActions
import org.junit.jupiter.api.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCartFeature {

    private val driver = SeleniumDriver().setChromeDriver()

    @AfterAll
    fun quit(){
        if (driver!=null){
            driver.quit()
        }
    }

    @Test
    fun adicionandoProdutoAoCarrinho(){
        // carregando a pagina no browser.
        driver.get("http://automationpractice.com/index.php")
        val shoppingCartActions = ShoppingCartActions(driver)
        shoppingCartActions.pesquisar("Dress")
        shoppingCartActions.addToCard()
        assertEquals("1 Product", shoppingCartActions.validarCarrinho())
    }

}