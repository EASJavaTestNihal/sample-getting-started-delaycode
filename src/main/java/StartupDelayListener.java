import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class StartupDelayListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application starting up - adding intentional delay");
        try {
            // Sleep for 30 seconds - much longer than our 5 second timeout
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Delay completed");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No action needed
    }
}
