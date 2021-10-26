package com.revature.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

// This class is really only replacing our Deployment Descriptor (web.xml)
public class ServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Access ApplicationContext
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();

        // Register our SpringConfig class that we created
        ac.register(SpringConfig.class);

        // Set Servlet Context for the Application Context
        ac.setServletContext(servletContext);

        // Add Spring's Front Controller
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ac));

        // Set some servlet settings
        servlet.setLoadOnStartup(1); // mirroring <load-on-start-up>1</load-on-start-up>
        servlet.addMapping("/"); // mirroring <url-pattern>

    }
}