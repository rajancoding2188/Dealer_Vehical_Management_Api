              Task 1
			  To manage Dealer and its vehical to create api for crud operation .
			  for Postman
			  FOR Dealer entity
			  
			POST:- http://localhost:8080/dealers/insert 
			  {
         "name":"Pradeep1 yadav" ,
        "email": "praveen2@123.com",
        "subscriptionType": "BASIC"
             }
			 
			Post:-http://localhost:8080/dealers/insert 
			 {
  "name": "soni singh",
  "email": "soni@123.com",
  "subscriptionType": "PREMIUM"
      }
	  
	  CRUD operation for Dealer
	  
	  
	  FOR VEHICAL ENTITY 
	  crud operation for vehicals
	POST:- localhost:8080/vehicals/insert
	
	  {
  "model": "Alto cars ",
  "price": 7000000,
  "status": "AVAILABLE",
  "dealer":
  {
    "dealer_id": 7
        
  }
   }
	  
	   Q1-write an api that fetch all vehical belonging to premium dealers only
	 GET:- http://localhost:8080/vehicals/all
			  
			  TASK 2
Post:-http://localhost:8080/dealers/generateEPayment	  
			  			  
 {
  "dealerId": 4,
  "amount": 12000,
  "method": "paytm"
}

			  
