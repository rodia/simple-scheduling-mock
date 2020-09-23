package org.scheduling.resources;

import org.scheduling.models.Class;
import org.scheduling.models.Student;
import org.scheduling.services.AttendStudentClassFacade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/api/v1/find")
@Produces(MediaType.APPLICATION_JSON)
public class FindController {

    @GET
    @Path("/student/name/{name}")
    public Collection<Student> showStudentAssignedToClass(@PathParam("name") String name) {
        return AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().findStudentByName(name);
    }

    @GET
    @Path("/class/title/{title}")
    public Collection<Class> showClassAssignedToStudent(@PathParam("title") String title) {
        return AttendStudentClassFacade.INSTANCE.getAttendStudentClassService().findClassByTitle(title);
    }
}
