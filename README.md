# Razzies

* Esse projeto é uma API RESTFul para possibilitar a leitura da lista de indicados e vencedores da categoria pior filme do Golden Raspberry Awards.

* Para isso será necessário a utilização de alguma ferramenta de teste de serviços RESTful (Web APIs) por meio do envio de requisições HTTP como o Postman. 

## Tecnologias 

Segue abaixo as tecnologias utilizadas nesse projeto.

* Java version  17

## Serviços Utilizados

* Github

## Começando

* Clone o projeto atual da branch Master
>    $ git clone -b master github.com/lucasasantiago/Razzies
* Execute o projeto localmente por uma IDE como o Intellij ou executando o jar gerado no build:
>    $ mvn clean install (Para gerar o jar) 
>    $ java -jar Razzies-0.0.1-SNAPSHOT.jar (executar no diretório do jar gerado anteriormente) 
* Teste o projeto pelo Postman importanto o curl abaixo:
>    $ curl --location 'http://localhost:8080/v1'

*Observação: para alterar o arquivo de dados de entrada, substituir o arquivo movielist.csv no path src\main\resources\input  

## Links

	- Repositório: https://github.com/lucasasantiago/Razzies


## Versionamento

0.0.1


## Autor

* **Lucas Almeida Santiago**: @lucasasantiago (https://github.com/lucasasantiago)


Obrigado pela visita!
