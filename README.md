# GrooveTechProject

## Objetivos
Esses projetos (desafio-aut-api e desafio-aut-api) tem como objetivo validar os desafios propostos pela GrooveTech

### Tecnologias Utilizadas

Necessária as tecnolgias abaixo para execução do projeto.

```
1. Java 8 ou superior
2. Maven
3. IntelliJ ou Eclipse
4. Allure Report
5. JUnit
```

### Instalação

Passo a passo para instalação:

1. Verificar se o java está instalado no seu computador 

```
1.1) Abrir o Prompt de Comando 
1.2) Digitar java -version
1.3) Caso apareça a mensagem: java version "1.8.0_171" Java(TM) SE Runtime Environment 
(build 1.8.0_171-b11) Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode) 
seu java está instalado corretamente, senão execute o passo 2 
```

2. Instalando e Configurando o Java

```
2.1) Faça o download: (https://www.java.com/pt_BR/download/)
2.2) Configure variaveis de ambiente: 
https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html
3.2) [a link](https://github.com/user/repo/blob/branch/other_file.md)
```
3. Verificar se o maven está instalado no seu computador 

```
3.1) Abrir o Prompt de Comando 
3.2) Digitar: mvn -v 
3.3) Caso apareça a mensagem: jApache Maven 3.5.3 (3383c37e1f9e9b3bc3df5050c29c8aff9f295297; 
2018-02-24T16:49:05-03:00) Maven home: /xxxxx/xxxxxx/apache-maven-3.5.3 seu maven está instalado corretamente,
senão execute o passo 4 
```
   
4. Instalando e Configurando o Maven  

```
4.1) Faça o download do maven no site: [Maven](https://maven.apache.org/) - Dependency Management
4.2) Para configurar as variaveis de ambiente para utilizar o maven acesse: https://pt.stackoverflow.com/questions/259927/como-configurar-vari%C3%A1veis-de-ambiente-maven-java tml
```

5. Criando um projeto maven para execuçao dos testes

```
https://cezarcruz.com.br/criando-um-projeto-maven-web-com-o-eclipse-jee/
```


## Desenvolvimento - Desafio API

Tecnologias:
```
JUnit
RestAssured
```
Classe de Teste: DesafioAutomacaoAPITest

Passo a passo do desenvolvimento:
1) Executei um get via restassured
2) Obtive o json atraves do JsonPath
3) Peguei tudo que estava dentro do atributo "results"
4) Atraves de um foreach obtive os valores dentro da lista "results" dos campos "title","director","producer"
5) Efetuei a validacão: "Exibir somente dos filmes que tenham George Lucas como diretor e que Rick McCallum tenha participado como produtor"
6) Printei os titulos no console
7) Validei o status code com um assert.

### Execucão do Teste
1) Após Configurar o projeto
2) Clicar botão direito na classe "DesafioAutomacaoAPITest" 
3) Run as + JUnit Test


## Desenvolvimento - Desafio WEB

Tecnologias:
```
JUnit
AllureReport
Selenium WebDriver
```

Criei uma estrutara Base para suportar todos os testes/pages/steps, contendo a seguinte estrutura:


#### 1) br.com.web.groove.tech.data
* TestData => Classe que possui as constantes utilizadas nos testes.

#### 2) br.com.web.groove.tech.helpers
* DriverFactory => Classe responsável pela inicializacão/definicão do navegador 
* Navigate => Classe responsável pela navegacão ate a url proposta.

#### 3) br.com.web.groove.tech.utils
* ConfigUtil => Classe de configuracao para leitura do arquivo config.properties
* ExplicitWaits => Classe que contem os metodos de esperas explicitas.
* Generator => Classe que contem metodos de geração de dados aleatórias.
* Screenshot => Classe que contem os metodos de screenshot para o report Allure.
* SeleniumInteracts => Classe que contem todas as interacoes com os componentes [WebElements].
* Utilities => Classe que contem metodos utilitarios para os testes.
* ValidationResults => Classe que contem os asserts pre definidos para os testes.


#### 1) br.com.web.groove.tech.base
* BaseTest => Classe base para todos os testes

#### 2) br.com.web.groove.tech.pages
* AuthenticatePage => Classe onde possui todos os elementos de interacão da pagina de autenticacão
* RegisterPage => Classe onde possui todos os elementos de interacão da pagina de cadastro de usuario.

#### 3) br.com.web.groove.tech.steps
* AuthenticatePage => Classe onde possui todos metodos de acão em relacao a pagina.
* RegisterPage => Classe onde possui todos metodos de acão em relacao a pagina.

#### 4) br.com.web.groove.tech.tests
* Onde fica as classes de testes que são executadas.

### Execução Teste - JUnit
1) Após Configurar o projeto
2) Clicar botão direito nas classe "RegisterEmailTest" & "AutheticateEmailTest" 
3) Run as + JUnit Test

### Execução Teste - Maven
1) Após Configurar o projeto
2) Abrir o terminal (mac) ou cmd (windows)
3) Acessar a pastar raiz do projeto
4) Inserir o comando mvn clean (limpar a pastar target do projeto caso exista)
5) Inserir o comando mvn test (executa todos os testes)
 5.1) Caso queira executar uma classe de teste pontualmente
   5.1.1) mvn test -Dtest="Nomedaclasse"
6) Após execuçao inserir o comando: mvn site(montar o report "allure")
7) Ir ate a pagina do projeto + target + site e abriro o arquivo "allure-maven-plugin.html"



   













