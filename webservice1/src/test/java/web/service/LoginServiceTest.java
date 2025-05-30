package web.service;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver webDriver;

    private final String LOGIN_URL = "file:///Users/adityabharti/Documents/SIT333-Software_Quality_and_Testing/7.1P/pages/login.html";

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/adityabharti/Downloads/chromedriver-mac-x64-2/chromedriver");
        webDriver = new ChromeDriver();
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void attemptLogin(String user, String pass, String birthDate) {
        webDriver.get(LOGIN_URL);
        pause(1);

        webDriver.findElement(By.id("username")).sendKeys(user);
        webDriver.findElement(By.id("passwd")).sendKeys(pass);
        webDriver.findElement(By.id("dob")).sendKeys(birthDate);

        WebElement submitButton = webDriver.findElement(By.cssSelector("[type=submit]"));
        submitButton.click();

        pause(1);
    }

    private void verifyLoginMessage(String expectedMessage) {
        String message = webDriver.findElement(By.id("loginStatus")).getText().trim();
        String expectedColor = expectedMessage.equals("success") ? "green" : "red";

        // Logging the result to the console
        System.out.println("Login result: " + message);

        // Assert the status message
        Assert.assertEquals(expectedMessage, message);

        // Verify the colour of the status message
//        String actualColor = webDriver.findElement(By.id("loginStatus")).getCssValue("color");
//        Assert.assertEquals(expectedColor, actualColor);
    }

    @Test
    public void validLogin() {
        attemptLogin("aditya", "aditya_pass", "2004-10-21");
        verifyLoginMessage("success");
    }

    @Test
    public void wrongPass() {
        attemptLogin("aditya", "incorrect_pass", "2004-10-21");
        verifyLoginMessage("fail");
    }

    @Test
    public void unknownUser() {
        attemptLogin("unknown_user", "aditya_pass", "2004-10-21");
        verifyLoginMessage("fail");
    }

    @Test
    public void wrongDob() {
        attemptLogin("aditya", "aditya_pass", "2005-10-21");
        verifyLoginMessage("fail");
    }

    @Test
    public void sqlInjection() {
        attemptLogin("' OR '1'='1", "' OR '1'='1", "' OR '1'='1");
        verifyLoginMessage("fail");
    }

    @Test
    public void nullInput() {
        attemptLogin("null", "null", "null");
        verifyLoginMessage("fail");
    }

    @Test
    public void emptyFields() {
        attemptLogin("", "", "");
        verifyLoginMessage("fail");
    }

    @Test
    public void badDateFormat() {
        attemptLogin("aditya", "aditya_pass", "2004:10:21");
        verifyLoginMessage("fail");
    }

    @After
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
