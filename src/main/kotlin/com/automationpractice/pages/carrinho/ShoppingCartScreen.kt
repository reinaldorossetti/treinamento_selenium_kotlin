package com.automationpractice.pages.carrinho

import com.automationpractice.core.BasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy


open class ShoppingCartScreen(driver: WebDriver) : BasePage(driver) {
    @FindBy(id = "search_query_top")
    lateinit var elemInputSearch: WebElement
    @FindBy(css = "button[name=\"submit_search\"]")
    lateinit var elemBtnSearch: WebElement
    @FindBy(css = "#center_column a.product-name")
    lateinit var elemLinkAddProduct: MutableList<WebElement>
    @FindBy(css = "form[id=\"buy_block\"] button[name=\"Submit\"] span")
    lateinit var elemButtonAddToCart: WebElement
    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    lateinit var elemLinkAddToCheckout: WebElement
    @FindBy(css = "#cart_title span[id=summary_products_quantity]")
    lateinit var elemSpanProductsQuantity: WebElement
}