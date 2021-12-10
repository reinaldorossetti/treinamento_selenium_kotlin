package com.automationpractice.core

import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.time.Duration

class BrowserConfig(){

    private val timeout = 30L

    fun setChrome(): WebDriver {
        val chromeOptions = ChromeOptions().apply {
           setPageLoadStrategy(PageLoadStrategy.NORMAL)
        }
        val driver = ChromeDriver(chromeOptions)
        driver.manage().apply {
            timeouts().implicitlyWait(Duration.ofSeconds(timeout))
            timeouts().pageLoadTimeout(Duration.ofSeconds(timeout))
            window().maximize()
        }
        return driver
    }
}

/*
fun main(){
    val driver = BrowserConfig().setChrome()
    driver.get("https://www.google.com")
}
*/
