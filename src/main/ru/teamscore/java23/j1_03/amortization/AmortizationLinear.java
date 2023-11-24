package ru.teamscore.java23.j1_03.amortization;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h1>Линейная амортизация</h1>
 * Для амортизируемого объекта задается срок службы в месяцах.
 * Каждый месяц списывается равная доля от первоначальной стоимости.
 * В конце срока службы стоимость объекта должна быть полностью списана.
 */
public final class AmortizationLinear extends Amortization {
    private final BigDecimal monthlyAmortization;
    public AmortizationLinear(double startValue, int usageMonths) {
        super(startValue);
        this.monthlyAmortization = this.startValue.divide(BigDecimal.valueOf(usageMonths), RoundingMode.HALF_UP);
    }

    @Override
    protected BigDecimal getNextAmortizationNotRounded() {
        return monthlyAmortization;
    }
}
