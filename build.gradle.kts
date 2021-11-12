import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.5.21"
    id("io.qameta.allure") version "2.8.1"
    id("org.gradle.test-retry") version "1.3.1"
    java
}

group "com.automationpractice"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20-M1")
    testImplementation("io.rest-assured:rest-assured:4.4.0")
    testImplementation("io.rest-assured:kotlin-extensions:4.4.0")
    testImplementation("io.rest-assured:json-schema-validator:4.4.0")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("io.qameta.allure:allure-junit5:2.16.1")
    implementation("io.qameta.allure:allure-okhttp3:2.16.1")

    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.0.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.0.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

allure {
    version = "2.14.0"
    downloadLinkFormat = "https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.14.0/allure-commandline-2.14.0.zip"
}


tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.SHORT
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}