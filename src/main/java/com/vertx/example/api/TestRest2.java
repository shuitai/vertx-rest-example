package com.vertx.example.api;


import com.vertx.example.annotation.AuditLog;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/system/user")
public class TestRest2 {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    @AuditLog(title = "query echo")
    public String query() {
        return "Hello world [query]!";
    }

    @POST
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String add() {
        return "Hello world [add]!";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String update() {
        return "Hello world [update]!";
    }

    @DELETE
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String delete() {
        return "Hello world [update]!";
    }
}
