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
open class BasePage(open var driver: WebDriver) {

     val baseURL = "http://automationpractice.com"

    fun WebElement.actionClick(){
        Actions(driver).moveToElement(this).click().build().perform()
    }

    fun visit(urlSite: String){
        driver.get(baseURL + urlSite)
    }

    fun WebDriver.find(locator: String, focus: Boolean = false): WebElement {
        val elem = driver.findElement(By.cssSelector(locator))
        if (focus) Actions(driver).moveToElement(elem).build().perform()
        return elem as WebElement
    }

    fun WebElement.type(text: String, focus: Boolean = false) {
        if (focus) Actions(driver).moveToElement(this).build().perform()
        this.sendKeys(text)
    }

    fun WebElement.contains(text: String) {
        when (this.text.contains(text)) {
            true -> println("Elemento encontrado na página.")
            else -> fail("Assert Falhou -> ${this.text}")
        }
    }

}

class BrowserConfig(){
    fun setChrome(): WebDriver {
        val chromeOptions = ChromeOptions().apply {
            this.setPageLoadStrategy(PageLoadStrategy.EAGER)
        }
        val driver = ChromeDriver(chromeOptions)
        driver.manage().apply {
            this.timeouts().implicitlyWait(Duration.ofSeconds(30))
            this.timeouts().pageLoadTimeout(Duration.ofSeconds(30))
            this.window().maximize()
        }
        return driver
    }
}
