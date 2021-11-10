package pt.ipleiria.estg.dei.ei.dae.academics.ws;

import pt.ipleiria.estg.dei.ei.dae.academics.dtos.CourseDTO;
import pt.ipleiria.estg.dei.ei.dae.academics.dtos.StudentDTO;
import pt.ipleiria.estg.dei.ei.dae.academics.ejbs.CourseBean;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("courses")  // relative url web path for this service
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON})  // injects header “Accept: application/json”
public class CourseService {
    @EJB
    CourseBean courseBean;

    // Converts an entity Student to a DTO Student class
    private CourseDTO toDTO(Course course){
        return new CourseDTO(
            course.getCode(),
            course.getName()
        );
    }

    // converts an entire list of entities into a list of DTOs
    private List<CourseDTO> toDTOs(List<Course> courses) {
        return courses.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET
    @Path("/")
    @RolesAllowed({"Student"})
    public List<CourseDTO> all(){
        return toDTOs(courseBean.getAllCourses());
    }

    @POST
    @Path("/")
    public Response createNewCourse(CourseDTO courseDTO){
        courseBean.create(
                courseDTO.getCode(),
                courseDTO.getName()
        );
        Course newCourse = courseBean.findCourseCode(courseDTO.getCode());
        /*
        if (newCourse == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        newCourse = courseBean.findCourseName(courseDTO.getName());
        if (newCourse == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        */
        return Response.status(Response.Status.CREATED)
                .entity(toDTO(newCourse))
                .build();
    }

}
