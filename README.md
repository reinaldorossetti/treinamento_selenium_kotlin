# treinamento_selenium_kotlin
Treinamento em Selenium em Kotlin

## Primeira Aula
Site Utilizado:
http://automationpractice.com/index.php

### 1. Configuração das bibliotecas  
Maven Central e adicionamos as bibliotecas do Selenium  
https://mvnrepository.com/repos/central  

### 2. Classes  
main >> nome_do_pacote >> nome_da_feature_page    
Actions => Classe aonde a gente vai realizar as ações.   
Screen => Classe aonde vamos mapear os elementos.    
PageBase => Classe aonde vai conter funções genericas.  

test >> nome_do_pacote >> carrinho_de_compra >> Vai conter as classes que faz a chamada dos nossos testes.   

### 3. Instancia do Driver Configuração:  
 ```
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

// declarando o driver
val driver: WebDriver
// utilizando o ChromeOptions para definir PageLoadStrategy, que espera a pagina carregar como inteira.
val chromeOptions = ChromeOptions()
chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER)
driver =  ChromeDriver(chromeOptions)
// configurando a espera máxima em 20 segundos.
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25))
// carregando a pagina no browser.
driver.get("http://automationpractice.com/index.php")
 ```
 
https://www.selenium.dev/documentation/webdriver/browser_manipulation/  
https://www.selenium.dev/documentation/support_packages/working_with_select_elements/  

### 4. Mapeamos o elemento e fazemos as funções.  
### 5. Criamos nossas chamadas dos testes utilizando o Junit.
 
Pesquisar e adicionar o produto no carrinho.  

