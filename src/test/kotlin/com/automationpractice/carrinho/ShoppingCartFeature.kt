package com.automationpractice.carrinho

import com.automationpractice.core.BasePage
import com.automationpractice.core.BrowserConfig
import com.automationpractice.pages.carrinho.ShoppingCartActions
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCartFeature {

    val driver = BrowserConfig().setChrome()
    val pageCart = ShoppingCartActions(driver)
    val base = BasePage(driver)

    @BeforeAll()
    fun beforeTests(){
    }

    @AfterAll
    fun quit() { driver.quit() }

    @Test
    fun adicionandoProdutoAoCarrinho(){
        base.visit("/")
        pageCart.realizarABusca()
    }

}