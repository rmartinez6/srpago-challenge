# srpago-challenge
## Build and Run

###Requisitos
 - Base de Datos MySql
    - user:root 
    - password:
 - Tomcat 9
 - Java 11
 - Maven 
 
1. Ejecutar mvn clean install
2. Montar el war generado en la capeta target en la carpeta webapps de tomcat
3. Tener una base de datos MySql con el nombre gaspurchase
4. Ejecutar el script createGasPurchaseTable.sql que esta en la carperta resources

##Pruebas del endpoint
Ejecutar en Postman o alguna herramienta el siguiente endpoint
POST
http://localhost:8080/GasolineWebService/gaspurchase
con body 
{
"email" : "info@srpago.com",
"name" : "juan",
"lastName" : "Perez",
"cardNumber" : "4242424242424244",
"expirationDateYear" : 2020,
"expirationDateMonth" : 12,
"gasType" :2,
"amount" : 350.00,
"gasStation" : "587fbd68edfe99480a072f15",
"sellerName" : "Pedro Perez"
}