package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
            "/Users/adityabharti/Downloads/chromedriver-mac-x64-2/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void givenValidCredentials_whenLogin_thenRedirectToQ1() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("aditya");
        driver.findElement(By.name("passwd")).sendKeys("aditya_pass");
        driver.findElement(By.name("dob")).sendKeys("21-10-004"); 
        driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
        assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void givenInvalidCredentials_whenLogin_thenShowErrorMessage() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("invalidUser");
        driver.findElement(By.name("passwd")).sendKeys("wrongPassword");
        driver.findElement(By.name("dob")).sendKeys("1990-01-01");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
        assertTrue(driver.getPageSource().contains("Invalid login credentials."));


        
    }

    @Test
    public void givenCorrectAdditionInQ1_whenSubmitted_thenRedirectToQ2() {
        givenValidCredentials_whenLogin_thenRedirectToQ1();
        driver.get("http://localhost:8080/q1");
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("5");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
        assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void givenIncorrectAdditionInQ1_whenSubmitted_thenShowErrorMessage() {
        givenValidCredentials_whenLogin_thenRedirectToQ1();
        driver.get("http://localhost:8080/q1");
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("4");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
        assertTrue(driver.getPageSource().contains("Incorrect answer, please try again."));


       
    }

    @Test
    public void givenCorrectSubtractionInQ2_whenSubmitted_thenRedirectToQ3() {
        givenValidCredentials_whenLogin_thenRedirectToQ1();
        driver.get("http://localhost:8080/q2");
        driver.findElement(By.name("number1")).sendKeys("5");
        driver.findElement(By.name("number2")).sendKeys("2");
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
        assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
