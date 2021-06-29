# orders (open in Docker)

METHOD 1

Go to the page: https://hub.docker.com/r/shandar1997/orders/tags?page=1&ordering=last_updated. There are docker images that are created in this program. The test database is already recorded in the Docker images. Pull these images from this page in own docker or insert in terminal commands:

docker pull shandar1997/orders:my_mysql

docker pull shandar1997/orders:my_jdk

Than create containers by these images. First run MySQL database:

docker run --name localhost -e MYSQL_ROOT_PASSWORD=1111 -e MYSQL_DATABASE=orders -e MYSQL_PASSWORD=1111 -d shandar1997/orders:my_mysql

Wait until the database is ready to use (about 30s). Then run application (app_jdk):

docker run -d -p 8089:8080 --name app --link localhost:mysql  shandar1997/orders:my_jdk

After open Postman, download file "Test Java.postman_collection.json" from repository. Import this collection into Postman and test all required endpoints. to see tips on how the endpoint works - right-click on the endpoint and select Edit

METHOD 2

Download archive, unpack it. Open this project in IDE. Open terminal in IDE and run command: docker-compose up

After open Postman, import collection "Test Java.postman_collection.json" from this project into Postman and test all required endpoints. to see tips on how the endpoint works - right-click on the endpoint and select Edit
------------------------------------------------------------------
HOW WORK THIS PROGRAM:

localhost:8089/createItem - first you need create items (in docker image my_mysql is already created 10 items). // in your localhost will use port 8080
localhost:8089/minPrice/{name} -  where "name" is name of item. if name doesn't exist, get all items.
localhost:8080/createOrder - in body of response join 'order' to 'item' 
    "item":{
        "id":id - identifier of item, that join by order
    },
    "price" = priceByOne (of item) * "quantity"
localhost:8080/deleteOrder/{id} - "id" - identifier of order. You can delete order, if it was created 10 minutes ago.
