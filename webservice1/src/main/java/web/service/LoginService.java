package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author 	aditya
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
	    return "aditya".equals(username) && 
	           "aditya_pass".equals(password) && 
	           "2004-10-21".equals(dob);
	}

	
	public String hashPassword(String password) {
        // Simulating some hashing logic
        if (password == null) return null;
        return "hashed_" + password;
    }
	
	public boolean validateDobFormat(String dob) {
        // Check for correct format, e.g., YYYY-MM-DD
        if (dob == null) return false;
        return dob.matches("\\d{4}-\\d{2}-\\d{2}");
    }
	
	
}