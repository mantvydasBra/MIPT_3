package com.example.mipt_3;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Test01CalculateForTesting() {
        String expectedResult = "4.0";
        String actualResult = MethodsForTest.calculateForTesting("2+2");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Test02CalculateForTesting() {
        String expectedResult = "2.0";
        String actualResult = MethodsForTest.calculateForTesting("(2+2)/2");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Test03CalculateForTesting() {
        float expectedResult = Float.parseFloat("-66.8989");
        float actualResult = Float.parseFloat(MethodsForTest.calculateForTesting("2-(1*8)^2-2*sqrt(6)"));
        assertEquals(expectedResult, actualResult, 0.0005);
    }

    @Test
    public void Test01ChangeSignForTesting() {
        String expectedResult = "";
        String actualResult = MethodsForTest.changeSignForTesting("-");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Test02ChangeSignForTesting() {
        String expectedResult = "25/2*35";
        String actualResult = MethodsForTest.changeSignForTesting("-25/2*35");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Test03ChangeSignForTesting() {
        String expectedResult = "-25/2*35.25+3.5";
        String actualResult = MethodsForTest.changeSignForTesting("25/2*35.25+3.5");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Test04ChangeSignForTesting() {
        String expectedResult = "-";
        String actualResult = MethodsForTest.changeSignForTesting("");
        assertEquals(expectedResult, actualResult);
    }
}