package ru.teamscore.java23.j1_03.amortization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmortizationLinearTest {

    @Test
    void getNextAmortizationNotRounded() {
        var amortization = new AmortizationLinear(1000, 100);
        assertEquals(10, amortization.getNextAmortization());
        amortization = new AmortizationLinear(121.12, 7);
        assertEquals(17.30, amortization.getNextAmortization(), 0.001);
    }
}