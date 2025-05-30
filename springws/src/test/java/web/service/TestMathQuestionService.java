package web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestMathQuestionService {

    // --- Q1: Addition Tests ---

    @Test
    public void testQ1Addition_PositiveIntegers() {
        assertEquals(13.0, MathQuestionService.q1Addition("6", "7"), 0.0);
    }

    @Test
    public void testQ1Addition_NegativeAndPositiveIntegers() {
        assertEquals(4.0, MathQuestionService.q1Addition("9", "-5"), 0.0);
        assertEquals(-15.0, MathQuestionService.q1Addition("-8", "-7"), 0.0);
    }

    @Test
    public void testQ1Addition_ZeroValues() {
        assertEquals(0.0, MathQuestionService.q1Addition("0", "0"), 0.0);
        assertEquals(9.0, MathQuestionService.q1Addition("9", "0"), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_NonNumericInput() {
        MathQuestionService.q1Addition("five", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ1Addition_EmptyStringInput() {
        MathQuestionService.q1Addition("", "2");
    }

    @Test
    public void testQ1Addition_LargeNumbers() {
        assertEquals(3_000_000_000.0, MathQuestionService.q1Addition("1500000000", "1500000000"), 0.0);
    }

    @Test
    public void testQ1Addition_DecimalValues() {
        assertEquals(9.8, MathQuestionService.q1Addition("4.3", "5.5"), 0.0);
    }

    // --- Q2: Subtraction Tests ---

    @Test
    public void testQ2Subtraction_ValidIntegers() {
        assertEquals(4.0, MathQuestionService.q2Subtraction("10", "6"), 0.0);
    }

    @Test
    public void testQ2Subtraction_NegativeValues() {
        assertEquals(14.0, MathQuestionService.q2Subtraction("5", "-9"), 0.0);
        assertEquals(-4.0, MathQuestionService.q2Subtraction("-6", "-2"), 0.0);
    }

    @Test
    public void testQ2Subtraction_ZeroValues() {
        assertEquals(0.0, MathQuestionService.q2Subtraction("0", "0"), 0.0);
        assertEquals(-7.0, MathQuestionService.q2Subtraction("0", "7"), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_NonNumericInput() {
        MathQuestionService.q2Subtraction("ten", "3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQ2Subtraction_EmptyStringInput() {
        MathQuestionService.q2Subtraction("", "3");
    }

    @Test
    public void testQ2Subtraction_LargeNumbers() {
        assertEquals(1_000_000_000.0, MathQuestionService.q2Subtraction("2000000000", "1000000000"), 0.0);
    }

    @Test
    public void testQ2Subtraction_SmallerMinuend() {
        assertEquals(-6.0, MathQuestionService.q2Subtraction("3", "9"), 0.0);
    }
}
