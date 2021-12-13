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
 * Passar o elemento mapeado sempre para a BasePage.
 */
open class BasePage(open var driver: WebDriver) {

    private val baseURL = "http://automationpractice.com"
    private val timeout = 30L
    private var wait: WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(timeout))

    /*
    Usando o page factory do Appium client, pra definir tempo dos elementos.
     */
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver, Duration.ofSeconds(timeout)), this)
    }

    /**
     * A função visit realiza o click e espera a condição ser possível realizar o clique.
     * @param urlSite url parcial do site.
     */
    fun visit(urlSite: String){
        driver.get(baseURL + urlSite)
    }

    /**
     * A função click realiza o click e espera a condição ser possível realizar o clique.
     * @param element passa o elemento mapeado no factory.
     * @param focus passar true para focar no elemento, false é o padrão.
     */
    fun click(elem: WebElement, focus: Boolean = false){
        val element = wait.until(ExpectedConditions.elementToBeClickable(elem))
        Actions(driver).moveToElement(element).click().build().perform()
    }

    /**
     * A função find realiza busca e espera a condição do elemento ser visível.
     * @param element passa o elemento mapeado no factory.
     * @param focus passar true para focar no elemento, false é o padrão.
     */
    fun find(element: WebElement, focus: Boolean = false): WebElement {
        if (focus) Actions(driver).moveToElement(element).build().perform()
        return wait.until(ExpectedConditions.visibilityOf(element))
    }

    /**
     * A função find realiza busca e espera a condição do elemento ser visível.
     * @param element passa o elemento mapeado no factory.
     * @param focus passar true para focar no elemento, false é o padrão.
     */
    fun find(element: By, focus: Boolean = false): WebElement {
        val elem = wait.until(ExpectedConditions.visibilityOfElementLocated(element))
        if (focus) Actions(driver).moveToElement(elem).build().perform()
        return elem
    }

    /**
     * A função find realiza busca e espera a condição do elemento ser visível.
     * @param element passa o elemento mapeado no factory.
     * @param text passar o texto que preencher no campo.
     * @param focus passar true para focar no elemento, false é o padrão.
     */
    fun sendKeys(element: WebElement, text: String, focus: Boolean = false) {
        if (focus) Actions(driver).moveToElement(element).build().perform()
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text)
    }

    /**
     * A função contains verifica se o elemento contém o texto esperado.
     * @param text passar o texto que vai validar no elemento.
     */
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
        clickJavaScript(element)
        Select(element).selectByVisibleText(text)
    }

}

/*
fun main(){
    val driver = BrowserConfig().setChrome()
    val base = BasePage(driver)
    base.visit("/")
}*/
