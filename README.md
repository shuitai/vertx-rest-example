# vertx-rest-example

Issue1 in TestRest.java(When Using custom annotation, the route will be incorrect)  

The expect result is:  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo2  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo3  

The test result is:  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /test/echo  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /test/echo2  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /echo3/echo3  
