package org.scheduling.resources;

import org.scheduling.models.Class;
import org.scheduling.services.ClassFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/api/v1/class")
@Produces(MediaType.APPLICATION_JSON)
public class ClassController {
    @GET
    public Collection<Class> getClasses() {
        return ClassFacade.INSTANCE.getClassService().getClasses();
    }

    @GET
    @Path("/{code}")
    public Response getClass(@PathParam("code") String code) {
        Class attend = ClassFacade.INSTANCE.getClassService().getClassByCode(code);

        if (attend == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(attend).build();
    }

    @POST
    public Response addClass(Class attend) {
        if (ClassFacade.INSTANCE.getClassService().addClass(attend) > 0) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    public Response updateClass(Class attend) {
        if (ClassFacade.INSTANCE.getClassService().updateClass(attend) > 0) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    public Response deleteClass(Class attend) {
        if (ClassFacade.INSTANCE.getClassService().deleteClass(attend) > 0) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
