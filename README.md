# Proyecto de entrada con Mercadolibre

## Overview

Service: Restful  
Language: Java  
Framework: Spring Boot  
Database: PostgreSQL  



![db shcema](/docs/db-schema.png?raw=true "Db Schema")

## API Documentation

### Host

https://do-mercadolibre-api.herokuapp.com

### Routes

#### Ping
 - GET /ping &rarr; Get server datetime

#### User
 - POST /user &rarr; Add user

    - Request: 

```json
{
    "email":"test@gmail.com"
}
```

 - GET /user/{id} &rarr; Get user by id
 - GET /user &rarr; Get all users
 - DELETE /user/{id} &rarr; Delete user
 - POST /user/favorite/add &rarr; Set item favorite for a user
    - Request
```json
{
    "userId": 3,
    "itemId":"MLA8"
}
```

 - DELETE /user/favorite/remove/{id} &rarr; Remove item favorite from a user

#### Items
 - POST /items &rarr; Add item
    - Request
```json
{
    "title" : "Fifth item",
    "price" : 90
}
```
 - POST /items/list &rarr; Add list of items
    - Request
```json
[
 	{
    	"title" : "Title MLA6",
    	"price" : 110
    },    {
        "title" : "Title MLA7",
        "price" : 500
    },    {
        "title" : "Title MLA8",
        "price" : 210
    },    {
        "title" : "Title MLA9",
        "price" : 150.12
    },    {
        "title" : "Title MLA10",
        "price" : 90
    }
]
```
 - GET /items &rarr; Get all items
 - GET /items/{id} &rarr; Get item by Id
 - DELETE /items/{id} &rarr; Delete item by id

#### Coupon
 - POST /coupon/add &rarr; Add coupon
    - Request
```json
{
    "value": 200
}
```
 - GET /coupon/stats &rarr; Get top 5 favorite items
    - Response
```json
[
    {
        "itemId": "MLA1",
        "total": "3"
    },
    {
        "itemId": "MLA2",
        "total": "2"
    },
    {
        "itemId": "MLA4",
        "total": "1"
    },
    {
        "itemId": "MLA5",
        "total": "1"
    },
    {
        "itemId": "MLA6",
        "total": "1"
    }
]
```
 - GET /coupon/{id} &rarr; Get coupon by id
 - GET /coupon &rarr; Get all coupons
 - POST /coupon &rarr; Validate coupons and items
    - Request
```json
{
    "item_ids": ["MLA1", "MLA2", "MLA3", "MLA4", "MLA5","MLA4"],
    "amount": 600
}
```
 - DELETE /coupon/{id} &rarr; Delete coupon by id

## Environment Variables

DB_URL=jdbc:postgresql://[db host]:[db port]/[db name]  
DB_USER=[db user]  
DB_PASSWORD=[db password]  
DB_DRIVER=org.postgresql.Driver  
PORT=[server port, default 5656]  

## Build API

#### Build and test

In api folder
`.\gradlew clean bootRun`

#### Build ready for deploy

In api folder
`.\gradlew clean build`

## Heroku

Create a Heroku App with Heroku Postgres add-on.  
Retrieve the Postgres credentials and add them as [environment variables](#environment-variables) to the app

### Deploy API to Heroku

docker login -u \_ -p [API KEY] registry.heroku.com (Api Key is found on heroku account settings)  
docker build --file=api/Dockerfile --rm=true -t registry.heroku.com/[APP NAME]/web .  
docker push registry.heroku.com/[APP NAME]/web  
heroku container:release web -a [APP NAME]  

## Performance Tests

Performance tests where made using Apache Jmeter.  
About 1666 request per minute were performed.  
Results can be found in [jmeter](/jmeter) folder  



