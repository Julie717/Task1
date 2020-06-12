package com.buyalskaya.day1.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FractionValidatorTest {
    FractionValidator fractionValidator;

    @BeforeClass
    public void setUp() {
        fractionValidator = new FractionValidator();
    }

    @DataProvider(name = "dataForValidateFractionString")
    public Object[][] dataForValidateFractionString() {
        return new Object[][]{
                {"15.5", true},
                {"1E-5", true},
                {"point", false},
                {"1.5.4", false},
                {null, false},
                {"-50001", false},
                {"50000.5", false}
        };
    }

    @Test(dataProvider = "dataForValidateFractionString")
    public void testParamsValidateFractionString(String number, boolean expected) {
        boolean actual = fractionValidator.validateFraction(number);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateFractionIntegerPositive() {
        boolean actual = fractionValidator.validateFraction(25.7);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberIntegerNegative() {
        boolean actual = fractionValidator.validateFraction(75000);
        assertFalse(actual);
    }
}
