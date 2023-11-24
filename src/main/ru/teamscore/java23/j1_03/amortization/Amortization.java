package ru.teamscore.java23.j1_03.amortization;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h1>Расчет амортизации</h1>
 * Амортизация - постепенное списание стоимости основных средств
 * (инструменты, оборудование, здания и т.п.) в связи с их
 * износом и устареванием.
 * Амортизация списывается раз в месяц и уменьшает первоначальную стоимость.
 * Методов расчета амортизации несколько.
 */
public abstract class Amortization {
    protected final BigDecimal startValue; // первоначальная стоимость в копейках
    protected BigDecimal depricatedValue; // остаточная стоимость в копейках
    private int month = 0; // месяц

    public Amortization(double startValue) {
        this.startValue = BigDecimal
                .valueOf(startValue)
                .setScale(2, RoundingMode.HALF_UP);
        depricatedValue = this.startValue;
    }

    /**
     * Начальная стоимость объекта.
     */
    public double getStartValue() {
        return startValue.doubleValue();
    }

    /**
     * Остаточная стоимость объекта на текущий месяц.
     */
    public double getDepricatedValue() {
        return depricatedValue.doubleValue();
    }

    /**
     * Текущий месяц.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Сумма амортизационных отчислений за текущий месяц без округления до копеек.
     */
    protected abstract BigDecimal getNextAmortizationNotRounded();

    /**
     * Сумма амортизационных отчислений за текущий месяц с округлением до копеек.
     */
    private BigDecimal getNextAmortizationDecimal() {
        if (getNextAmortizationNotRounded().compareTo(depricatedValue) > 0) {
            return depricatedValue;
        }
        return getNextAmortizationNotRounded()
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Сумма амортизационных отчислений за текущий месяц с округлением до копеек.
     */
    public double getNextAmortization() {
        return getNextAmortizationDecimal()
                .doubleValue();
    }


    /**
     * Общая сумма амортизации за весь период.
     */
    public final double getTotalAmortization() {
        return startValue
                .subtract(depricatedValue)
                .doubleValue();
    }

    /**
     * Списать амортизацию за текущий месяц.
     */
    public void deprecate() {
        month++;
        depricatedValue = depricatedValue.subtract(getNextAmortizationDecimal());
    }
}
