package com.automationpractice.pages.carrinho

import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

class ShoppingCartActions(val driver: WebDriver) : ShoppingCartScreen() {

    fun pesquisar(valor: String){
        driver.findElement(elemInputPesquisar).let {
            it.clear()
            it.sendKeys(valor)
        }
        driver.findElement(elemBtnPesquisar).click()
    }

    fun addToCard(value: String="Add to cart"){
        val action = Actions(driver)
        val elemNovo = driver.findElements(elemLinkAddToCard).get(0)
        action.moveToElement(elemNovo).click().build().perform()

        val elemCheckout = driver.findElement(elemLinkCheckout)
        if (elemCheckout.text.equals(value)){
            println("validacao com sucesso!")
        }
        action.moveToElement(elemCheckout).click().build().perform()
        driver.findElement(elemAddToCheckout).click()
    }

    fun validarCarrinho(): String {
        return driver.findElement(elemQuatidadeProduto).text
    }

}
