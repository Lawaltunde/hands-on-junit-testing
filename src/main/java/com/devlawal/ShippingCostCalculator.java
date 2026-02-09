package com.devlawal;

public class ShippingCostCalculator {
   public static enum Region {
        Local,
        International
    };

    public double calculate(double weightInKg, Region region, boolean isExpress) {
        double total = 0.0;

        if (weightInKg < 0) {
            throw new IllegalArgumentException("Values below zero are not allowed");
        }
        if (weightInKg >= 0 && weightInKg < 1.0) {
            total += 5.00;
        }
        if (weightInKg >= 1.0 && weightInKg < 5.0 && region.equals(Region.Local)) {
            total += 10.00;
        }
        if (weightInKg >= 1.0 && weightInKg < 5.0 && region.equals(Region.International)) {
            total += 20.00;
        }
        if (isExpress) {
            total += 15.00;
        }
        return total;
    }
}


