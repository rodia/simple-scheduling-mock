package org.scheduling.resources;

import org.scheduling.models.AttendStudentClass;
import org.scheduling.models.Class;
import org.scheduling.models.Student;
import org.scheduling.services.AttendStudentClassFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/api/v1/assigned")
@Produces(MediaType.APPLICATION_JSON)
public class AssignedController {

    @POST
    public Response addAssigned(AttendStudentClass attend) {
        if (AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().addAssigned(attend) > 0) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    public Response deleteAssigned(AttendStudentClass attend) {
        if (AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().deleteAssigned(attend) > 0) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/class/{code}")
    public Collection<Student> showStudentAssignedToClass(@PathParam("code") String code) {
        return AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().showStudentAssignedToClass(code);
    }

    @GET
    @Path("/student/{id}")
    public Collection<Class> showClassAssignedToStudent(@PathParam("id") int id) {
        return AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().showClassAssignedToStudent(id);
    }
}
