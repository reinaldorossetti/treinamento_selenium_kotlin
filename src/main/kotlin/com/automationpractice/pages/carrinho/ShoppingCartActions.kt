package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver

class ShoppingCartActions(driver: WebDriver) : ShoppingCartScreen(driver) {

    fun realizarABusca(produtoName: String="Dress"){
        val elementSearchInput = driver.findElement(elemInputSearch)
        elementSearchInput.sendKeys(produtoName)
        val elementSearchButton = driver.findElement(elemBtnSearch)
        elementSearchButton.click()
    }

    fun adicionaProdutoAoCarrinho(){
        val elementProduct = driver.findElements(elemLinkAddProduct)
        elementProduct[(0..2).random()].click()
        val elementButtonAddToCart = driver.findElement(elemButtonAddToCart)
        elementButtonAddToCart.click()
        val elementCheckout = driver.findElement(elemLinkAddToCheckout)
        elementCheckout.click()
    }

    fun validarCarrinho(): String {
        return driver.findElement(elemSpanProductsQuantity).text
    }

}