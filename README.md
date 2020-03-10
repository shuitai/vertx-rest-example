# vertx-rest-example

Issue1 in TestRest.java(When Using custom annotation, the route will be incorrect)
=================

The expect result is:  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo2  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo  
[INFO] [2020-03-10 21:54:41] Registering route:      GET /test/echo3  

The test result is:  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /test/echo  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /test/echo2  
[INFO] [2020-03-10 21:55:26] Registering route:      GET /echo3/echo3  


Issue2 in TestRest2.java(When Using custom annotation, it occurs java.lang.IllegalArgumentException: Missing or empty route '@Path'!)
=================

Exception in thread "main" java.lang.IllegalArgumentException: Missing or empty route '@Path'!  
	at com.zandero.utils.Assert.isFalse(Assert.java:38)
	at com.zandero.utils.Assert.notNullOrEmptyTrimmed(Assert.java:89)
	at com.zandero.rest.data.RouteDefinition.path(RouteDefinition.java:487)
	at com.zandero.rest.data.RouteDefinition.join(RouteDefinition.java:252)
	at com.zandero.rest.AnnotationProcessor.join(AnnotationProcessor.java:120)
	at com.zandero.rest.AnnotationProcessor.collect(AnnotationProcessor.java:101)
	at com.zandero.rest.AnnotationProcessor.get(AnnotationProcessor.java:43)
	at com.zandero.rest.RestRouter.register(RestRouter.java:124)
	at com.zandero.rest.RestRouter.register(RestRouter.java:82)
	at com.zandero.rest.RestBuilder.getRouter(RestBuilder.java:410)
	at com.zandero.rest.RestBuilder.build(RestBuilder.java:452)
	at com.vertx.example.BootStrap.main(BootStrap.java:36)