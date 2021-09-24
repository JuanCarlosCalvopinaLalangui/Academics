package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton //this EJB will have only one instance in the application
@Startup ///this EJB will be automatically instantiated once the application is deployed onto the server
public class ConfigBean {
    @PostConstruct
    public void populatedDB() {
        System.out.println("----------------Academics Project---------------");

    }
}
