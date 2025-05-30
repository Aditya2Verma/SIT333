package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224277942";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "aditya";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testLeapYear() {
		Assert.assertTrue(DateUtil.isLeapYear1(2020));
		Assert.assertTrue(DateUtil.isLeapYear1(2024));
		Assert.assertTrue(DateUtil.isLeapYear1(2000));
		System.out.println("Test Passed: Valid leap years");
	}

	@Test
	public void testNonLeapYear() {
		Assert.assertFalse(DateUtil.isLeapYear1(2023));
		Assert.assertFalse(DateUtil.isLeapYear1(1900));
		Assert.assertFalse(DateUtil.isLeapYear1(2021));
		System.out.println("Test Passed: Valid non-leap years");
	}

	@Test
	public void testValidDay29InLeapYear() {
		DateUtil date = new DateUtil(29, 2, 2024);
		Assert.assertEquals(29, date.getDay());
		System.out.println("Test Passed: Valid Feb 29 on leap year");
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDay29InNonLeapYear() {
		System.out.println("Expecting RuntimeException for Feb 29 in non-leap year");
		new DateUtil(29, 2, 2023);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDay31InApril() {
		System.out.println("Expecting RuntimeException for April 31");
		new DateUtil(31, 4, 2024);
	}

	@Test
	public void testValidDay30InApril() {
		DateUtil date = new DateUtil(30, 4, 2024);
		Assert.assertEquals(30, date.getDay());
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDay32() {
		System.out.println("Expecting RuntimeException for day 32");
		new DateUtil(32, 1, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidDayZero() {
		System.out.println("Expecting RuntimeException for day 0");
		new DateUtil(0, 1, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidMonthZero() {
		System.out.println("Expecting RuntimeException for month 0");
		new DateUtil(1, 0, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidMonthGreaterThanTwelve() {
		new DateUtil(1, 13, 2024);
	}

	@Test(expected = RuntimeException.class)
	public void testInvalidYearBelowRange() {
		System.out.println("Expecting RuntimeException for year below 1700");
		new DateUtil(1, 1, 1699);
	}

	@Test
	public void testEndOfYearToNewYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}

	@Test
	public void testDecrementIntoLeapYearFebruary() {
		DateUtil date = new DateUtil(1, 3, 2024); // Leap year
		date.decrement();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}
}
