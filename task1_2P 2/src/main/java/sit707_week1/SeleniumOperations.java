package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

/**
 * Selenium automation tasks for SIT707 Week 1.
 * 
 * Student: Aditya
 * ID: 224277942
 */
public class SeleniumOperations {

    // Utility method to pause execution
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void launchAndExitChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/adityabharti/Downloads/chromedriver-mac-x64/chromedriver");

        System.out.println("Launching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        System.out.println("WebDriver instance created: " + driver);

        waitInSeconds(5);
        driver.close();
    }

    public static void launchMaximizeAndExitChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/adityabharti/Downloads/chromedriver-mac-x64/chromedriver");

        System.out.println("Starting Chrome browser and maximizing window...");
        WebDriver driver = new ChromeDriver();
        System.out.println("WebDriver instance created: " + driver);

        waitInSeconds(3);
        driver.manage().window().maximize();
        waitInSeconds(3);

        driver.close();
    }

    public static void visitSeleniumSiteAndClose() {
        System.setProperty("webdriver.chrome.driver", "/Users/adityabharti/Downloads/chromedriver-mac-x64/chromedriver");

        System.out.println("Opening Chrome browser to access Selenium's official site...");
        WebDriver driver = new ChromeDriver();
        System.out.println("WebDriver instance: " + driver);

        waitInSeconds(2);
        driver.get("https://selenium.dev");
        waitInSeconds(4);

        driver.close();
    }

    public static void openGoogleResizeAndClose() {
        System.out.println("Greetings from 224277942, Aditya");

        System.setProperty("webdriver.chrome.driver", "/Users/adityabharti/Downloads/chromedriver-mac-x64/chromedriver");

        System.out.println("Launching Chrome and navigating to Google...");
        WebDriver driver = new ChromeDriver();
        System.out.println("WebDriver instance initialized: " + driver);

        waitInSeconds(2);
        driver.get("https://www.google.com");

        // Resize to 640x480
        driver.manage().window().setSize(new Dimension(640, 480));
        waitInSeconds(2);

        // Resize to 1280x960
        driver.manage().window().setSize(new Dimension(1280, 960));
        waitInSeconds(2);

        driver.close();
    }
}