# contact-book

### spring mvc crud saas api using Java Collection Framework as Database

#### To Test:

`mvn Test`

it will run the unit tests and will show the result for the same in console

#### To Build:

`mvn clean verify`

it will create .jar executable for contact-book in /target directory

#### To Run Server:

`java -jar contact-book.jar`

it will show the SpringBoot initialisation log with the server details

-server will bind to 8080 port which is hardcoded

#### To Access Api:

use [Postman](https://www.getpostman.com/downloads/) to trigger requests to access contact-book rest api.

#### Api EndPoints:

The api is using Collection Framework as db so in order to access data one has to add contacts first. Once server is restarted, the data will be lost and will have to be added again.

##### 1) Add Contact

`POST http://localhost:8080/contact`

a json contact payload has to be sent in the following format:

` {
        "firstName": "Pranav",
        "lastName": "Kapoor",
        "cellPhone": "1015337891",
        "homePhone": "1135937891",
        "address": "San Fransisco"
 }`

##### 2) List All Contacts

`GET http://localhost:8080/contacts`

the above endpoint will get all the contacts added.

To sort the response a request param "sort" is used with values "asc" or "desc" for sorting the result list in ascending order or descending order (by firstname)

`GET http://localhost:8080/contacts?sort=asc`

##### 3) Get a Contact by Id

`GET http://localhost:8080/contact?cid=1`

the above endpoint will get the contact with the id 1 (if exists)

##### 4) List All Contacts by any field (firstname/lastname/cellphone/homephone)

`GET http://localhost:8080/contact/pr`

the above endpoint will get all the contacts which have "pr" in firstname/lastname/cellphone/homephone.

To sort the response a request param "sort" is used with values "asc" or "desc" for sorting the result list in ascending order or descending order with another request param "sortfield", which specifies which field you want to sort the result with respect to.

`GET http://localhost:8080/contact/pr?sortfield=firstname&sort=asc`

the above request will search for "pr" in all the fields but will sort the resulting list with respect to the request params sent with request ie field= firstname and ascending sorting is requested.

##### 5) Update Contact (by Id)

`PUT http://localhost:8080/contact/`

a json contact payload has to be sent in the following format:

`  {
        "id": 1,
        "firstName": "Pranav",
        "lastName": "Kapoorr",
        "cellPhone": "7488706094",
        "homePhone": "6479937891",
        "address": "London"
 }
 
 api will take the id frm this payload and check if it exists, if exists it will change the old fields with the new values from the payload received. It adds the updated time field which is null before any updation.
 
 
##### 6) Delete Contact (by Id)

`DELETE http://localhost:8080/contact/1`

the above request will delete the contact whose Id is "1".


