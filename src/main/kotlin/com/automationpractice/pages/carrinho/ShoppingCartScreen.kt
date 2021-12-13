package com.automationpractice.pages.carrinho

import com.automationpractice.core.BasePage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

open class ShoppingCartScreen(driver: WebDriver) : BasePage(driver) {
    @FindBy(id = "search_query_top")
    lateinit var elemInputSearch: WebElement
    @FindBy(css = "button[name=\"submit_search\"]")
    lateinit var elemBtnSearch: WebElement
    @FindBy(css = "a[title=\"Printed Summer Dress\"]")
    lateinit var elemLinkAddToCard: WebElement
    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    lateinit var elemLinkAddToCheckout: WebElement
    @FindBy(css = "#cart_title span[id=summary_products_quantity]")
    lateinit var elemSpanProductsQuantity: WebElement
    @FindBy(css = "button[name=\"Submit\"] span")
    lateinit var elemBtnCheckout: WebElement
}