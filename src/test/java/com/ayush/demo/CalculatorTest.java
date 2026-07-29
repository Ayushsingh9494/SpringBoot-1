package com.ayush.demo;

import com.ayush.demo.Java.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void testAddition(){
        int actual = calculator.add(7,7);
        assertEquals(14,actual);
    }

    @Test
    void testSubtraction() {
        int result1 = calculator.subtract(10, 4);
        int result2 = calculator.subtract(4, 10);

        assertEquals(6, result1);
        assertEquals(-6, result2);
    }

    @Test
    void testisEven() {
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(5));
    }

    @Test
    void testdivideByZero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot Divide by Zero", ex.getMessage());
    }

    @Test
    void testMultiply() {
        int result1 = calculator.multiply(3, 5);
        assertEquals(15, result1);
    }

    @Test
    void testDivision() {
        int result1 = calculator.divide(10, 2);
    }

}
