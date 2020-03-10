package com.vertx.example;

import com.google.inject.Module;
import com.vertx.example.api.TestRest;
import com.vertx.example.api.TestRest2;
import com.vertx.example.inject.GuiceInjectionProvider;
import com.vertx.example.module.AdminModule;
import com.vertx.example.vertical.HttpServerVertical;
import com.zandero.rest.RestBuilder;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BootStrap {

    public static Module[] getModules() {
        return new Module[]{
                new AdminModule()
		};
    }


    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(HttpServerVertical.class);

        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx(vertxOptions);
        DeploymentOptions options = new DeploymentOptions();


        int port = 8080;
        Router router = new RestBuilder(vertx).injectWith(new GuiceInjectionProvider(getModules())).register(TestRest.class,
                TestRest2.class).build();
        HttpServerVertical httpServerVertical = new HttpServerVertical(router, port);
        vertx.deployVerticle(httpServerVertical, options, res -> {
            logger.info("=========== start ConeyApplication successful, port: {} ===========", port);
        });
    }
}
