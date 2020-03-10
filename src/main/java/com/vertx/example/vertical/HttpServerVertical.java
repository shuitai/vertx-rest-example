package com.vertx.example.vertical;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServerVertical extends AbstractVerticle {

    protected final Logger logger = LoggerFactory.getLogger(HttpServerVertical.class);

    private static final int MAX_WEBSOCKET_FRAME_SIZE = 1000000;

    private static final int HTTP_PORT = 8080;

    private int port = HTTP_PORT;

    private HttpServer server;

    private Router router;

    public HttpServerVertical(Router router, int port) {
        this.router = router;
            if (port > 0) {
                this.port = port;
        }
    }

    @Override
    public void start(Promise<Void> future) throws Exception {
        super.start();
        HttpServerOptions options = new HttpServerOptions().setMaxWebsocketFrameSize(MAX_WEBSOCKET_FRAME_SIZE).setPort(port);
        server = vertx.createHttpServer(options);
        server.requestHandler(router);
        server.listen(result -> {
            if (result.succeeded()) {
                future.complete();
            } else {
                future.fail(result.cause());
                logger.error("Fail to start HttpServerVertical: {}", result.cause());
            }
        });
    }

    @Override
    public void stop(Promise<Void> future) {
        logger.info("[HttpServerVertical] stop");
        if (server == null) {
            future.complete();
            logger.error("Fail to stop HttpServerVertical!");
            return;
        }
        server.close(result -> {
            if (result.failed()) {
                future.fail(result.cause());
                logger.error("Fail to close RestVertical: {}", result.cause());
            } else {
                future.complete();
            }
        });
    }
}
