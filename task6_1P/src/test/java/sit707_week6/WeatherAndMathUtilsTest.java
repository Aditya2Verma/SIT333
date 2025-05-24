package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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

    // === weatherAdvice() tests ===

    @Test
    public void testDangerousWind() {
        String result = WeatherAndMathUtils.weatherAdvice(75.0, 2.0);
        Assert.assertEquals("CANCEL", result);
    }

    @Test
    public void testDangerousRain() {
        String result = WeatherAndMathUtils.weatherAdvice(20.0, 6.5);
        Assert.assertEquals("CANCEL", result);
    }

    @Test
    public void testDangerousCombo() {
        String result = WeatherAndMathUtils.weatherAdvice(46.0, 4.5);
        Assert.assertEquals("CANCEL", result);
    }

    @Test
    public void testWarningWindOnly() {
        String result = WeatherAndMathUtils.weatherAdvice(50.0, 2.0);
        Assert.assertEquals("WARN", result);
    }

    @Test
    public void testWarningRainOnly() {
        String result = WeatherAndMathUtils.weatherAdvice(10.0, 5.0);
        Assert.assertEquals("WARN", result);
    }

    @Test
    public void testAllClear() {
        String result = WeatherAndMathUtils.weatherAdvice(10.0, 1.0);
        Assert.assertEquals("ALL CLEAR", result);
    }

    // === isEven() tests ===

    @Test
    public void testEvenNumberTrue() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testOddNumberFalse() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    // === isPrime() tests ===

    @Test
    public void testPrimeNumberTrue() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3)); // should be true
    }

    @Test
    public void testEvenNumberNotPrime() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4)); // even number
    }

    

    @Test
    public void testOnePrimeBuggyLogic() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1)); // due to faulty logic
    }

}
