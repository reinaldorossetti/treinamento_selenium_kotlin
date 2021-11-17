package com.automationpractice.pages.carrinho

import com.automationpractice.core.BaseCore
import org.openqa.selenium.By

open class ShoppingCartScreen: BaseCore() {
    val elemInputPesquisar: By = By.id("search_query_top")
    val elemBtnPesquisar: By = By.cssSelector("button[name=\"submit_search\"]")
    val elemLinkAddToCard: By = By.cssSelector("a[title=\"Printed Summer Dress\"]")
    val elemLinkCheckout: By = By.cssSelector("form[id=\"buy_block\"] button[name=\"Submit\"] span")
    val elemAddToCheckout: By = By.cssSelector("a[title=\"Proceed to checkout\"]")
    val elemQuatidadeProduto: By = By.cssSelector("#cart_title span[id=summary_products_quantity]")
}