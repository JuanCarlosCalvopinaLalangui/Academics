package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton //this EJB will have only one instance in the application
@Startup ///this EJB will be automatically instantiated once the application is deployed onto the server
public class ConfigBean {
    @EJB
    private StudentBean studentBean;

    @EJB
    private CourseBean courseBean;

    @PostConstruct
    public void populatedDB() {
        try {
            System.out.println("----------------Academics Project---------------");
            System.out.println("----------------Creating Courses---------------");

            courseBean.create(1,"EI");
            courseBean.create(2,"EEC");
            courseBean.create(3,"MD");

            System.out.println("----------------Creating Students---------------");

            studentBean.create("123","123","Juan","juan@mail.pt",1);
            studentBean.create("456","456","Carlos","carlos@mail.pt",3);
            studentBean.create("789","789","Alison","alison@mail.pt",2);

        }catch (Exception exception){
            System.out.println("Error: " +exception.getMessage());
        }

    }
}
