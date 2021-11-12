package com.automationpractice.pages.carrinho

import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.time.Duration

class ShoppingCartActions: ShoppingCartScreen() {
}

fun main(){
    val driver: WebDriver
    // utilizando o ChromeOptions para definir PageLoadStrategy, que espera a pagina carregar como inteira.
    val chromeOptions = ChromeOptions()
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER)
    driver =  ChromeDriver(chromeOptions)
    // configurando a espera máxima em 20 segundos.
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25))
    // carregando a pagina no browser.
    driver.get("http://automationpractice.com/index.php")
}