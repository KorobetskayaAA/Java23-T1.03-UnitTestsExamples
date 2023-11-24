package ru.teamscore.java23.j1_03.amortization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmortizationNonlinearTest {

    @Test
    void getAmortizationNorm() {
        var amortization = new AmortizationNonlinear(1000, 5);
        assertEquals(5, amortization.getAmortizationNorm());
    }

    @Test
    void getNextAmortizationNotRounded() {
        var amortization = new AmortizationNonlinear(50_000, 20);
        assertEquals(10_000, amortization.getNextAmortization());
        amortization.deprecate();
        assertEquals(8_000, amortization.getNextAmortization());
        amortization.deprecate();
        assertEquals(6_400, amortization.getNextAmortization());
        amortization.deprecate();
        assertEquals(5_120, amortization.getNextAmortization());
        amortization.deprecate();
        assertEquals(4_096, amortization.getNextAmortization());
        amortization.deprecate();
        assertEquals(16_384, amortization.getNextAmortization());
    }
}