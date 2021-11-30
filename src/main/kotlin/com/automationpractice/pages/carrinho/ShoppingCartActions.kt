package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver

class ShoppingCartActions(): ShoppingCartScreen() {

    fun pesquisar(valor: String){
        driver.findElement(elemInputPesquisar).let {
            it.clear(); it.sendKeys(valor)
        }
        driver.findElement(elemBtnPesquisar).click()
    }

    fun addToCard(value: String="Add to cart"){

        val elemNovo = driver.findElements(elemLinkAddToCard)
        elemNovo.forEach { println(it.text) }
        elemNovo.first().actionClick()
        val elemCheckout = driver.findElement(elemLinkCheckout)
        if (elemCheckout.text.equals(value)){
            println("validacao com sucesso!")
        }
        elemCheckout.actionClick()
        driver.findElement(elemAddToCheckout).click()
    }

    fun validarCarrinho(): String {
        return driver.findElement(elemQuatidadeProduto).text
    }

}
