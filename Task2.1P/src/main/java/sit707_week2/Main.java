package sit707_week2;

/**
 * Hello world!
 * Runs GitHub login form automation using Selenium.
 * @author Aditya
 */
public class Main 
{
    public static void main(String[] args)
    {
    	
       // SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");

       SeleniumOperations.github_registration_page("https://github.com/signup?source=login");
    }
}