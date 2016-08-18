package com.later.rest;

/**
 * Created by later <later.h.p@qq.com> on 2016/8/17.
 */

import com.later.domain.Later;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "laters say : " + msg;

        return Response.status(200).entity(output).build();

    }

    //below is json get and post sample
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Later getTrackInJSON() {

        Later later = new Later();
        later.setTitle("Enter Sandman");
        later.setSinger("Metallica");

        return later;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Later later) {

        String result = "later saved : " + later;
        return Response.status(201).entity(result).build();

    }
}