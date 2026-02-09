package com.devlawal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static com.devlawal.ShippingCostCalculator.Region;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShippingCostCalculatorTest {
    private ShippingCostCalculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new ShippingCostCalculator();
    }

    @Test
    void shouldChargeFiveDollarsForSmallPackage() {
        assertThat(underTest.
                calculate(0.5, Region.Local, false)).isEqualTo(5.0);
    }

    @Test
    void shouldChargeTenEurosForLocalStandardShipping() {
        assertThat(underTest.calculate(2.0, Region.Local, false)).isEqualTo(10.00);
    }

    @Test
    void shouldChargeTwentyEurosForInternationalShipping() {
        assertThat(underTest.calculate(2.0, Region.International, false)).isEqualTo(20.00);
    }

    @Test
    void shouldAddExpressFee() {
        assertThat(underTest.calculate(0.5, Region.Local, true)).isEqualTo(20.00);
    }
    @Test
    void shouldThrowException() {
        assertThatThrownBy(() -> underTest.calculate(-1.0, Region.Local, true)).
                isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Values below zero are not allowed");
    }
}