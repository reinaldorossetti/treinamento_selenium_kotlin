package com.automationpractice.core

import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import java.sql.Driver
import java.time.Duration

/**
 * Classe BaseCore contém funções básicas para as pages.
 */
open class BaseCore(open val driver: WebDriver) {

    fun WebElement.actionClick(){
        val action = Actions(driver)
        action.moveToElement(this).click().build().perform()
    }

}

/**
 * Classe SeleniumDriver que contém as configurações do browser.
 */
class SeleniumDriver(){

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