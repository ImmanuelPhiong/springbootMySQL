*To try this program, importing the given database to the local server is needed.*
*Start the local database server and run the java application (SpringbootMySQLApp.java).*
*The port number is not assigned, so its using the default value of 8080.*
*The file application.properties might need to be modified to connect it to your own local server.*


*Main pages that available with POST, PUT, GET, DELETE requests are:

localhost:{port}/productline

localhost:{port}/product

localhost:{port}/office

localhost:{port}/employee

localhost:{port}/customer

localhost:{port}/payment

localhost:{port}/order

localhost:{port}/orderdetail


*To send GET request of specific data of a table we can use the primary key of each table after the /table_name.
For example:

localhost:{port}/customer/{customerNumber}

localhost:{port}/product/{productCode}

localhost:{port}/orderdetail/{orderNumber}

localhost:{port}/orderdetail/{orderNumber}/{productCode}

localhost:{port}/payment/{customerNumber}

localhost:{port}/payment/{customerNumber}/{checkNumber}
