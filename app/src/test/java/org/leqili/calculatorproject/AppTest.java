/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.leqili.calculatorproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void calculator() throws Exception{
        App classUnderTest = new App();
        int firstNumber = 999;
        int secondNumber = 3;
        String operation = "/";
        assertEquals(333, classUnderTest.answer(firstNumber, secondNumber, operation));
    } 
        
}

