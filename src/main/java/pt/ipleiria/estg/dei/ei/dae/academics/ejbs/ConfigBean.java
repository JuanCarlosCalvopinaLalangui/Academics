package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton //this EJB will have only one instance in the application
@Startup ///this EJB will be automatically instantiated once the application is deployed onto the server
public class ConfigBean {
    @EJB
    StudentBean studentBean;

    @PostConstruct
    public void populatedDB() {
        try {
            System.out.println("----------------Academics Project---------------");
            System.out.println("----------------Creating Students---------------");

            studentBean.create(123,"123","Juan","juan@mail.pt");
            studentBean.create(456,"456","Carlos","carlos@mail.pt");
            studentBean.create(789,"789","Alison","alison@mail.pt");

        }catch (Exception exception){
            System.out.println("Error: " +exception.getMessage());
        }

    }
}
