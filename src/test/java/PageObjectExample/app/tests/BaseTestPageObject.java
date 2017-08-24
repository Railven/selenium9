package PageObjectExample.app.tests;

import PageObjectExample.app.app.Application;
import org.testng.annotations.BeforeTest;

public class BaseTestPageObject {
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @BeforeTest
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }
}
