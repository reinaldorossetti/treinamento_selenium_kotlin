package com.automationpractice.carrinho

import com.automationpractice.core.BasePage
import com.automationpractice.core.BrowserConfig
import com.automationpractice.pages.carrinho.ShoppingCartActions
import org.junit.jupiter.api.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCartFeature {

    private val driver = BrowserConfig().setChrome()
    private val pageCart = ShoppingCartActions(driver)
    private val page = BasePage(driver)

    @AfterAll
    fun quit() = driver.quit()

    @Test
    fun adicionandoProdutoAoCarrinho(){
        // carregando a pagina no browser.
        page.visit("/")
        pageCart.pesquisar("Dress")
        pageCart.addToCard()
        pageCart.validarCarrinho("1 Product")
    }

}