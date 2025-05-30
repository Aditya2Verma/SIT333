package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	 @Test
	    public void testStudentIdentity() {
	        String studentId = "224277942";
	        Assert.assertNotNull("Student ID is null", studentId);
	    }

	    @Test
	    public void testStudentName() {
	        String studentName = "Aditya";
	        Assert.assertNotNull("Student name is null", studentName);
	    }

	    @Test
	    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
	        LoginStatus result = LoginForm.login(null, null);
	        Assert.assertFalse("Expected login to fail with null credentials", result.isLoginSuccess());
	    }

	    @Test
	    public void testNullUserWrongPass() {
	        LoginStatus result = LoginForm.login(null, "092");
	        Assert.assertFalse("Login should fail with null username and wrong password", result.isLoginSuccess());
	    }

	    @Test
	    public void testNullUserValidPass() {
	        LoginStatus result = LoginForm.login(null, "ahsan_pass");
	        Assert.assertFalse("Login should fail with null username and correct password", result.isLoginSuccess());
	    }

	    @Test
	    public void testInvalidUserEmptyPass() {
	        LoginStatus result = LoginForm.login("ahs", null);
	        Assert.assertFalse("Login should fail with incorrect username and null password", result.isLoginSuccess());
	    }

	    @Test
	    public void testInvalidCredentialsBothWrong() {
	        LoginStatus result = LoginForm.login("sha", "678");
	        Assert.assertFalse("Login should fail with incorrect username and password", result.isLoginSuccess());
	    }

	    @Test
	    public void testIncorrectUserCorrectPass() {
	        LoginStatus result = LoginForm.login("sha", "ahsan_pass");
	        Assert.assertFalse("Login should fail with wrong username and valid password", result.isLoginSuccess());
	    }

	    @Test
	    public void testCorrectUserMissingPass() {
	        LoginStatus result = LoginForm.login("ahsan", null);
	        Assert.assertFalse("Login should fail with valid username and null password", result.isLoginSuccess());
	    }

	    @Test
	    public void testCorrectUserWrongPass() {
	        LoginStatus result = LoginForm.login("ahsan", "098");
	        Assert.assertFalse("Login should fail with valid username and incorrect password", result.isLoginSuccess());
	    }

	    @Test
	    public void testValidLoginInvalidCodeNull() {
	        LoginStatus result = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Expected login to succeed with correct credentials", result.isLoginSuccess());
	        Assert.assertFalse("Validation code should fail when null", LoginForm.validateCode(null));
	    }

	    @Test
	    public void testValidLoginInvalidCodeWrong() {
	        LoginStatus result = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Login should succeed", result.isLoginSuccess());
	        Assert.assertFalse("Validation code should fail with incorrect value", LoginForm.validateCode("202"));
	    }

	    @Test
	    public void testFullSuccessPath() {
	        LoginStatus result = LoginForm.login("ahsan", "ahsan_pass");
	        Assert.assertTrue("Login should succeed with valid credentials", result.isLoginSuccess());
	        Assert.assertTrue("Validation code should be accepted when correct", LoginForm.validateCode("123456"));
	    }
}



