package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("aditya", "aditya_pass", "2004-10-21"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("wrong", "aditya_pass", "2004-10-21"));
    }

    @Test
    public void testInvalidDobFormat() {
        assertFalse(LoginService.login("aditya", "aditya_pass", "2004:10:21"));
    }

    @Test
    public void testNullInputs() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testHashPassword() {
        LoginService service = new LoginService();
        assertEquals("hashed_secret", service.hashPassword("secret"));
    }

    @Test
    public void testDobValidator() {
        LoginService service = new LoginService();
        assertTrue(service.validateDobFormat("2004-10-21"));
        assertFalse(service.validateDobFormat("2004/10/21"));
    }
}
