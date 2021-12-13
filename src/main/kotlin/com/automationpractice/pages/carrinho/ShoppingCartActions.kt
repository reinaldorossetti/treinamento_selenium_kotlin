package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver

class ShoppingCartActions(driver: WebDriver) : ShoppingCartScreen(driver) {

    /*

     */
    fun realizarABusca(produtoName: String="Dress"){
        // localizei o elemento
        val element = driver.findElement(elemInputSearch)
        // enviei o texto para o campo input
        element.sendKeys(produtoName)
        // localizamos o botão de pesquisa
        val elementSearchButton = driver.findElement(elemBtnSearch)
        // realizamos o click
        elementSearchButton.click()
        Thread.sleep(10000)
        //sendKeys(element, produtoName, true)
    }
}