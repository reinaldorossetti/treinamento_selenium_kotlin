# treinamento_selenium_kotlin
Treinamento em Selenium em Kotlin

Selenium WebDriver é um projeto abrangente que encapsula uma variedade de ferramentas e bibliotecas que permitem a automação do navegador da web. 
O Selenium fornece especificamente uma infraestrutura para a especificação W3C WebDriver - 
uma plataforma e interface de codificação neutra de linguagem compatível com todos os principais navegadores da Web.

https://github.com/SeleniumHQ/selenium

No link abaixo mostra a estrutura do Selenium:
https://www.selenium.dev/documentation/webdriver/understanding_the_components/

Terminologia:
API: Interface de programação de aplicativo. Este é o conjunto de “comandos” que você usar para manipular o WebDriver.  

Biblioteca: um módulo de código que contém as APIs e o código necessário para implementá-las. As bibliotecas são específicas   
para cada ligação de linguagem, por exemplo, arquivos .jar para Java, arquivos .dll para .NET, etc.  

Driver: Responsável por controlar o navegador atual. A maioria dos drivers é criada pelos próprios fornecedores de navegadores.   

Os drivers geralmente são módulos executáveis que são executados no sistema com o próprio navegador, não no sistema que executa o conjunto de testes. (Embora possam ser o mesmo sistema.) NOTA: Algumas pessoas se referem aos drivers como proxies.  

Framework: Uma biblioteca adicional usada como suporte para suítes WebDriver. Essas estruturas podem ser estruturas de teste,   
como JUnit ou NUnit. Eles também podem ser estruturas que suportam recursos de linguagem natural, como Cucumber ou Robotium.   

Frameworks também podem ser escritos e usados para coisas como manipulação ou configuração do sistema em teste,   
criação de dados, oráculos de teste, etc.


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

