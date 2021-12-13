package com.example.mipt_3;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodsForTest {

    public static String calculateForTesting (String equation) {
        // Don't do anything if there are less than 2 digits
        if (equation.length() < 2) {
            return "none";
        }

        // Replace special chars
        equation = equation.replaceAll("÷", "/");
        equation = equation.replaceAll("×", "*");
        equation = equation.replaceAll("(\\d)√", "$1*√");
        equation = equation.replaceAll("√+(\\d)", "sqrt($1)");

        Pattern pattern = Pattern.compile("/0");
        Matcher matcher = pattern.matcher(equation);
        // Check for division by 0
        if (matcher.find()) {
            return "Can't divide by 0!";
        }


        Expression exp = new Expression(equation);
        // For debugging
        exp.checkSyntax();
        System.out.println(exp.getErrorMessage());
        String result = String.valueOf(exp.calculate());

        if (result.equals("NaN")) {
            result = "Error!";
        }

        // Setting max chars for answer to not flood the textview
        result = String.format("%.13s", result);
        return result;
    }

    public static String changeSignForTesting (String equation) {
        // StringBuilder to make it more simple
        StringBuilder sb = new StringBuilder(equation);
        // If it's the first character, just add it
        if (equation.length() == 0) {
            return "-";
        }
        // if there is only one character and it's a -, just remove it
        else if (equation.length() == 1 && equation.charAt(0) == '-') {
            return "";
        }
        // If there is a - in front, remove it from front
        else if (equation.charAt(0) == '-') {
            equation = equation.substring(1);
            return equation;
        }
        // Else, just add in front of string with StringBuilder.
        else {
            sb.insert(0, '-');
            equation = sb.toString();
            return equation;
        }
    }
}
