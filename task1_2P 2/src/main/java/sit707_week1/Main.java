package sit707_week1;

/**
 * Main class to execute different Selenium tasks.
 * 
 * Student: Aditya
 * ID: 224277942
 */
public class Main {

    public static void main(String[] args) {
        int choice = 4; // Change this number to run a different task (1-4)

        switch (choice) {
            case 1:
                SeleniumOperations.launchAndExitChrome();
                break;
            case 2:
                SeleniumOperations.launchMaximizeAndExitChrome();
                break;
            case 3:
                SeleniumOperations.visitSeleniumSiteAndClose();
                break;
            case 4:
                SeleniumOperations.openGoogleResizeAndClose();
                break;
            default:
                System.out.println("Invalid operation selected.");
                break;
        }
    }
}