package ru.teamscore.java23.j1_03.percent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PercentCalculatorTest {

    @Test
    void limitedPercentInner() {
        assertEquals(0.5, PercentCalculator.limitedPercent(1, 2));
        assertEquals(0.01, PercentCalculator.limitedPercent(0.1, 10));
        assertEquals(0.9, PercentCalculator.limitedPercent(90_000_000, 100_000_000));
    }

    @Test
    void limitedPercentNaN() {
        assertTrue(Double.isNaN(PercentCalculator.limitedPercent(0, 0)));
        assertTrue(Double.isNaN(PercentCalculator.limitedPercent(1, -1)));
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1e-15, -1, Double.NEGATIVE_INFINITY })
    void limitedPercentZero(double share) {
        assertEquals(0, PercentCalculator.limitedPercent(share, 100));
    }
    @ParameterizedTest
    @ValueSource(doubles = { 100, 100 + 1e-15, 1000 })
    void limitedPercentOne(double share) {
        assertEquals(1, PercentCalculator.limitedPercent(share, 100));
    }
}