package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver

class ShoppingCartActions(driver: WebDriver) : ShoppingCartScreen(driver) {

    fun realizarABusca(produtoName: String="Dress"){
        elemInputSearch.apply { click(); sendKeys(produtoName) }
        click(elemBtnSearch)
    }

    fun adicionaProdutoAoCarrinho(){
        elemLinkAddProduct.random().click()
        click(elemButtonAddToCart)
        click(elemLinkAddToCheckout)
    }

    fun validarCarrinho(): String {
        return elemSpanProductsQuantity.text
    }

}