package by.Isachenko.Lesson10.tests;

import org.junit.Test;

public class ProductLogTest extends TestBase{
    @Test
    public void testProductLog() {
        app.logAsAdmin();
        app.selectFolder("Rubber Ducks");
        app.checkSiteLog();
        System.out.println("Test is over.");
    }
}
