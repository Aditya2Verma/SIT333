package web.service;

public class MathQuestionService {

    /**
     * Computes the sum of two input values for Question 1.
     * 
     * @param number1 first number as string
     * @param number2 second number as string
     * @return the addition result as double
     * @throws IllegalArgumentException if input values are not valid numbers
     */
    public static double q1Addition(String number1, String number2) {
        try {
            double val1 = Double.parseDouble(number1);
            double val2 = Double.parseDouble(number2);
            return val1 + val2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid inputs provided for addition operation.");
        }
    }

    /**
     * Computes the difference of two input values for Question 2.
     * 
     * @param number1 first number as string
     * @param number2 second number as string
     * @return the subtraction result as double
     * @throws IllegalArgumentException if input values are not valid numbers
     */
    public static double q2Subtraction(String number1, String number2) {
        try {
            double val1 = Double.parseDouble(number1);
            double val2 = Double.parseDouble(number2);
            return val1 - val2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid inputs provided for subtraction operation.");
        }
    }
}
