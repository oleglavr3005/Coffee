package lab.epam.olavr.service;
import java.util.ResourceBundle;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitializeLanguage implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ResourceBundle rb = ResourceBundle.getBundle("lang_en");
        sce.getServletContext().setAttribute("lang", rb); 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
