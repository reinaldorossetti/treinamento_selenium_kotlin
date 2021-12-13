package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver

class ShoppingCartActions(driver: WebDriver) : ShoppingCartScreen(driver) {

    fun pesquisar(valor: String){
        elemInputSearch.apply { clear(); sendKeys(valor)}
        click(elemBtnSearch, true)
    }

    fun addToCard(value: String="Add to cart"){
        clickByJS(elemLinkAddToCard)
        find(elemBtnCheckout).contains(value)
        click(find(elemBtnCheckout))
        click(elemLinkAddToCheckout)
    }

    fun validarCarrinho(texto: String) {
        elemSpanProductsQuantity.contains(texto)
    }

}
