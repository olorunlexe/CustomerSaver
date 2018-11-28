/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interswitch.client;

import com.interswitch.util.ServiceResponse;
import com.interswitch.controller.CustomerControllerLocal;
import com.interswitch.model.Customer;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author therapy
 */
@Path("Customer")
public class CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    @Inject
    CustomerControllerLocal customer;

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(
            @FormParam("Name") String name,
            @FormParam("AccountNumber") int acctNo,
            @FormParam("LoginID") String loginId,
            @FormParam("Password") String password,
            @FormParam("Email") String email,
            @FormParam("MobileNumber") int mobileNo) {
        ServiceResponse response = new ServiceResponse();
        try {
            customer.createCustomer(name,acctNo,loginId,password,email,mobileNo);
            response.setResponseCode(0);
            response.setResponseMessage("Successful");
        } catch (Exception e) {
            response.setResponseCode(10);
            response.setResponseMessage("Error processing request");
        }
        return Response.ok(response).build();
    }

    @POST
    @Path("getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(
            @FormParam("LoginID") String loginId) {
        try {
            return customer.getCustomer(loginId);
        } catch (Exception e) {
            System.out.println("Unable to get user");
            return null;
        }
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @FormParam("LoginID") String loginId,
            @FormParam("Password") String password) {
        ServiceResponse response = new ServiceResponse();

        try {
            if (customer.login(password,loginId)) {
                response.setResponseMessage("Login Successful");
            } else {
                response.setResponseMessage("Login Failed");

            }
        } catch (Exception e) {
            response.setResponseMessage("Login Failed with error");

        }
        return Response.ok(response).build();
    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
