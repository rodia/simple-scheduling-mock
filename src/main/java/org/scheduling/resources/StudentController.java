package org.scheduling.resources;

import org.scheduling.models.Student;
import org.scheduling.services.StudentFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/api/v1/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {
    @GET
    public Collection<Student> getStudents() {
        return StudentFacade.INSTANCE.getStudentService().getStudents();
    }

    @POST
    public Response addStudent(Student student) {
        StudentFacade.INSTANCE.getStudentService().addStudent(student);

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") int id) {
        Student student = StudentFacade.INSTANCE.getStudentService().getStudentById(id);

        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(student).build();
    }
}
