package com.later.rest;

/**
 * Created by later <later.h.p@qq.com> on 2016/8/17.
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "laters say : " + msg;

        return Response.status(200).entity(output).build();

    }

}