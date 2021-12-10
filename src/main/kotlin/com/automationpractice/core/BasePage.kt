package com.automationpractice.core

import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.fail

/**
 * Classe BaseCore contém funções globais básicas para as pages.
 * Funções específicas devem esta na Page.
 */
open class BasePage(open var driver: WebDriver) {

    private val baseURL = "http://automationpractice.com"
    private val timeout = 30L
    private var wait: WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(timeout))

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver, Duration.ofSeconds(timeout)), this)
    }

    fun visit(urlSite: String){
        driver.get(baseURL + urlSite)
    }

    fun click(elem: WebElement, focus: Boolean = false){
        val element = wait.until(ExpectedConditions.elementToBeClickable(elem))
        Actions(driver).moveToElement(element).click().build().perform()
    }

    fun find(element: WebElement, focus: Boolean = false): WebElement {
        if (focus) Actions(driver).moveToElement(element).build().perform()
        return wait.until(ExpectedConditions.visibilityOf(element))
    }

    fun sendKeys(element: WebElement, text: String, focus: Boolean = false) {
        if (focus) Actions(driver).moveToElement(element).build().perform()
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text)
    }

    fun WebElement.contains(text: String) {
        when (this.text.contains(text)) {
            true -> println("Elemento encontrado na página.")
            else -> fail("Assert Falhou -> ${this.text}")
        }
    }

    /**
     * A funcao clickJS realiza o click via javascript.
     * @param element passa o elemento mapeado no factory.
     */
    fun clickJavaScript(element: WebElement) {
        (driver as JavascriptExecutor).executeScript("arguments[0].click();", element)
    }

    /**
     * A funcao selectByVisibleText faz a selecao do combobox passando o By e o texto.
     * @param locator passar o elemento via By do selenium.
     * @param text passar o texto visivel que deseja selecionar.
     */
    fun selectByVisibleText(element: WebElement, text: String) {
        if (element != null) { clickJavaScript(element) }
        Select(element).selectByVisibleText(text)
    }

}
