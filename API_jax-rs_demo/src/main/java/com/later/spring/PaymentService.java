package com.later.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
/**
 * Created by liqiliang <liqiliang@baibu.la> on 2016/8/18.
 */

@Component
@Path("/payment")
public class PaymentService {

    @Autowired
    TransactionBo transactionBo;

    @GET
    @Path("/later")
    public Response savePayment() {

        String result = transactionBo.save();

        return Response.status(200).entity(result).build();

    }

}