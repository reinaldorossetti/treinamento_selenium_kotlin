package com.seleniumVsCypress

import com.automationpractice.core.BaseCore
import org.junit.jupiter.api.*
import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TesteBatalha: BaseCore() {

    var cy = BaseCore().driver

    @AfterAll
    fun quit() = cy.quit()

    @Test
    fun round1Login(){
        cy.visit("https://demo.applitools.com")
        cy.get("#username", true).type("colbyfayock")
        cy.get("#password", true).type("Password1234")
        cy.get("#log-in", false).click()
        cy.get(".element-header", true).contains("Financial Overview")
    }

}