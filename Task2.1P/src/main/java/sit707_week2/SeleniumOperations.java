package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * Selenium automation tasks - Task 2.1
 * Student: Aditya
 * ID: 224277942
 */
public class SeleniumOperations {

    private static final String CHROME_DRIVER_PATH = "/Users/adityabharti/Downloads/chromedriver-mac-x64/chromedriver";

    private static void pauseExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        System.out.println("Browser launched successfully.");
        pauseExecution(2);

        driver.get(url);
        System.out.println("Navigated to Officeworks registration page.");

        driver.findElement(By.id("firstname")).sendKeys("Aditya");
        driver.findElement(By.id("lastname")).sendKeys("Verma");
        driver.findElement(By.id("phoneNumber")).sendKeys("0416684897");
        driver.findElement(By.id("email")).sendKeys("addyverma528@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Asdf@1234");
        driver.findElement(By.id("confirmPassword")).sendKeys("Asdf@1234");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@data-testid='account-action-btn']"));
        submitBtn.click();
        System.out.println("Submitted registration form.");

        takeScreenshot(driver, "officeworks_form.png");

        pauseExecution(3);
        driver.quit();
        System.out.println("Browser session ended.");
    }

    public static void github_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        System.out.println("Launching GitHub signup test...");
        pauseExecution(2);

        driver.get(url);
        System.out.println("Opened GitHub signup page.");

        try {
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("addyverma528@gmail.com");
            System.out.println("Entered email.");

            pauseExecution(2);

            // After email, GitHub loads password field dynamically
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Asdf@1234");
            System.out.println("Entered password.");

            pauseExecution(2);

            WebElement usernameField = driver.findElement(By.id("login"));
            usernameField.sendKeys("addyverma528");
            System.out.println("Entered username.");

            pauseExecution(2);

            WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(), 'Create account')]"));
            continueBtn.click();
            System.out.println("Clicked create account.");

            takeScreenshot(driver, "github_signup.png");

        } catch (Exception e) {
            System.out.println("Something went wrong during GitHub automation: " + e.getMessage());
        }

        pauseExecution(3);
        driver.quit();
        System.out.println("GitHub test complete.");
    }

    private static void takeScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(fileName);
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}