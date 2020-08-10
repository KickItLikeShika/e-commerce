# E-commerce

E-commerce RESTful API based on Java, SpringBoot, Spring security, JWT, hibernate with MySQL.

# REST API Endpoints

Open Postman 'https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop'

	http://localhost:8080
		
		/auth
			POST /register - Register - required: email, username, password
			POST /login - Login - required: username, password

		/product
			GET /get - Get all the products 
			GET /getid/{id} - Get a specific product by its id
			GET /getname/{name} - Get a list of prodcut by their names
			POST /add - Add a product - required: name, price, description

		/order
			GET /get - Get all the orders for the current logged in user
			POST /addtocart - Make an order and add the product to the cart - 
						required: product id, full name, address, city, zip code, phone 

		/edit
			PUT /user - Edit the current logged in user info - required: email, username, password
			PUT /product/{id} - Edit a specific product info - required: name, price, description
			DELETE /order/{id} - Cancel an order

# How to use 

Open Postman, make a POST request 'http://localhost:8080/auth/register' and type in the body in a JSON format an email, username, password then send the request and you're gonna be registerd.
Then make another POST request 'http://lovalhost:8080/auth/login' and type in the body in a JSON format a username, password and send the request. It generate a token and sends it back to you -because of using JWT authorization-.
And after that all you requests must be authorized, to make that you have to add a header in the headers tab in postman the 'key' = 'Authorization', 'value' = 'Bearer <The generated token you got after logging in>.
Follow the same way for each request.

# Hints 

- All inputs and outputs using JSON format.
