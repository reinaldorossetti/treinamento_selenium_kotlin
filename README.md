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

Frameworks também podem ser escritos e usados para coisas como manipulação ou configuração do sistema em teste.


## Primeira Aula
Site Utilizado:
http://automationpractice.com/index.php

### 1. Configuração das bibliotecas e Estrutura do Projeto.
Maven Central e adicionamos as bibliotecas do Selenium  
https://mvnrepository.com/repos/central  

### 2. Classes  
main >> nome_do_pacote >> nome_da_feature_page    
Actions => Classe aonde a gente vai realizar as ações.  
Screen => Classe aonde vamos mapear os elementos.  
PageBase => Classe aonde vai conter funções genericas.  

ShoppingCartFeature >> ShoppingCartActions >> ShoppingCartScreen >> BasePage

test >> nome_do_pacote >> carrinho_de_compra >> Vai conter as classes que faz a chamada dos nossos testes.   

### 3. Instancia do Driver Configuração:  
https://www.selenium.dev/pt-br/documentation/webdriver/capabilities/shared/
 ```
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


class BrowserConfig(){
    fun setChrome(): WebDriver {
        val chromeOptions = ChromeOptions().apply {
            this.setPageLoadStrategy(PageLoadStrategy.NORMAL)
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
    
 ```
 
https://www.selenium.dev/documentation/webdriver/browser_manipulation/  
https://www.selenium.dev/documentation/support_packages/working_with_select_elements/  

### 4. Mapeamos o elemento e fazemos as funções, o padrão geralmente utilizando no Kotlin\Java é usando o By.  
Deixei um padrão para o elemento, pois é sempre complicado dar nome as coisas:
elem => Define o que um elemento e quando digitar elem vai listar todos os elementos.
Tipo de Elemento => Define o tipo do elemento Link, Button (Btn), Span.
Nome que simboliza o que o elemento faz.

```kotlin
    val elemInputSearch: By = By.id("search_query_top")
    val elemBtnSearch: By = By.cssSelector("button[name=\"submit_search\"]")
    val elemLinkAddToCard: By = By.cssSelector("a[title=\"Printed Summer Dress\"]")
    val elemBtnCheckout: By = By.cssSelector("form[id=\"buy_block\"] button[name=\"Submit\"] span")
    val elemLinkAddToCheckout: By = By.cssSelector("a[title=\"Proceed to checkout\"]")
    val elemSpanProductsQuantity: By = By.cssSelector("#cart_title span[id=summary_products_quantity]")
```

Page factory
https://github.com/SeleniumHQ/selenium/wiki/PageFactory
```kotlin
    @FindBy(id = "search_query_top")
    lateinit var elemBtnSearch: WebElement
    @FindBy(name = "submit_search")
    lateinit var elemBtnSearch: WebElement
    @FindBy(css = "a[title=\"Printed Summer Dress\"]")
    lateinit var elemLinkAddToCard: WebElement
    @FindBy(css = "form[id=\"buy_block\"] button[name=\"Submit\"] span")
    lateinit var elemBtnCheckout: WebElement
    @FindBy(css = "a[title=\"Proceed to checkout\"]")
    lateinit var elemLinkAddToCheckout: WebElement
    @FindBy(css = "#cart_title span[id=summary_products_quantity]")
    lateinit var elemSpanProductsQuantity: WebElement
```


### 5. Criamos as nossas chamadas dos testes utilizando o Junit.
```
@Test
fun adicionandoProdutoAoCarrinho(){
    // carregando a pagina no browser.
    driver.get("http://automationpractice.com/index.php")
    val shoppingCartActions = ShoppingCartActions()
    shoppingCartActions.pesquisar("Dress")
    shoppingCartActions.addToCard()
    assertEquals("1 Product", shoppingCartActions.validarCarrinho())
}
``` 
Procurando um elemento:
https://www.selenium.dev/documentation/webdriver/elements/

Uso do selecionar valor no combobox:
https://www.selenium.dev/documentation/webdriver/elements/select_elements/

Actions para mover para o elemento:
https://www.selenium.dev/documentation/webdriver/actions_api/mouse/

Primeira Aula - Realizando o Pesquisar:  
https://www.youtube.com/watch?v=gGjHkR0lrAQ


