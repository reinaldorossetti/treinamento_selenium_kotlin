package com.automationpractice.pages.carrinho

import com.automationpractice.core.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

open class ShoppingCartScreen(driver: WebDriver) : BasePage(driver) {
    val elemInputSearch: By = By.id("search_query_top")
    val elemBtnSearch: By = By.cssSelector("button[name=\"submit_search\"]")
    val elemLinkAddProduct: By = By.cssSelector("#center_column a.product-name")
    val elemButtonAddToCart: By = By.cssSelector("form[id=\"buy_block\"] button[name=\"Submit\"] span")
    val elemLinkAddToCheckout: By = By.cssSelector("a[title=\"Proceed to checkout\"]")
    val elemSpanProductsQuantity: By = By.cssSelector("#cart_title span[id=summary_products_quantity]")
}