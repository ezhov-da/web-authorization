package ru.ezhov.auth.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("test")
public class Test {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@Context SecurityContext securityContext) {
        return Response.ok(
                "{\"username\": \"" + securityContext.getUserPrincipal().getName() + "\"}")
                .build();
    }
}
