package com.automationpractice.core

import org.openqa.selenium.By
import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import java.time.Duration
import kotlin.test.fail

/**
 * Classe BaseCore contém funções básicas para as pages.
 */
open class BaseCore() {

    var driver: WebDriver = chrome()

    private fun chrome(): WebDriver {
        val chromeOptions = ChromeOptions().apply {
            this.setPageLoadStrategy(PageLoadStrategy.EAGER)
        }
        val driver = ChromeDriver(chromeOptions)
        driver.manage().apply {
            this.timeouts().implicitlyWait(Duration.ofSeconds(25))
            this.window().maximize()
        }
        return driver
    }

    fun WebElement.actionClick(){
        val action = Actions(driver)
        action.moveToElement(this).click().build().perform()
    }

    fun WebDriver.find(locator: String): WebElement {
        return driver.findElement(By.cssSelector(locator))
    }

    fun WebDriver.visit(url: String) {
        driver.get(url)
    }

    fun WebDriver.get(locator: String, focus: Boolean = false): WebElement {
        val elem = driver.findElement(By.cssSelector(locator))
        if (focus) Actions(driver).moveToElement(elem).click().build().perform()
        return elem
    }

    fun WebElement.type(text: String) {
        this.sendKeys(text)
    }

    fun WebElement.contains(text: String) {
        when (this.text.contains(text)) {
            true -> println("Elemento encontrado na página.")
            else -> fail("Assert Falhou -> ${this.text}")
        }
    }

}

/**
 * Classe SeleniumDriver que contém as configurações do browser.
 */
open class SeleniumDriver() {

    fun setChromeDriver(): WebDriver {
        val driver: WebDriver
        // utilizando o ChromeOptions para definir PageLoadStrategy, que espera a pagina carregar como inteira.
        val chromeOptions = ChromeOptions()
        //  NONE ("none"),
        //  EAGER ("eager"),
        //  NORMAL ("normal")
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER)
        driver =  ChromeDriver(chromeOptions)
        // configurando a espera máxima em 20 segundos.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25))
        driver.manage().window().maximize()
        return driver
    }

}