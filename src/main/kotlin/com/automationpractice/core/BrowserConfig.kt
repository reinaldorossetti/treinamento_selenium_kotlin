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
            this.setPageLoadStrategy(PageLoadStrategy.NORMAL)
        }
        val driver = ChromeDriver(chromeOptions)
        driver.manage().apply {
            this.timeouts().implicitlyWait(Duration.ofSeconds(timeout))
            this.timeouts().pageLoadTimeout(Duration.ofSeconds(timeout))
            this.window().maximize()
        }
        return driver
    }
}