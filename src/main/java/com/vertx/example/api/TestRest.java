package com.vertx.example.api;

import com.vertx.example.annotation.AuditLog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestRest {

    @GET
    @Path("/echo")
    @Produces(MediaType.TEXT_HTML)
    @AuditLog(title = "echo")
    public String echo() {

        return "Hello world!";
    }

    @GET
    @Path("/echo2")
    @Produces(MediaType.TEXT_HTML)
    @AuditLog(title = "echo2")
    public String echo2() {

        return "Hello world2!";
    }

    @GET
    @Path("/echo3")
    @Produces(MediaType.TEXT_HTML)
    public String echo3() {

        return "Hello world3!";
    }
}
