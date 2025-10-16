// Task 5: VAT calculation using double and BigDecimal
// Author: Saad Hakim, ID: 61551, Group: 7

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        // --- Using double (with error) ---
        double net = 9.99;
        double vat = 0.23;
        double gross = net * (1 + vat);
        double totalGross = gross * 10000;
        double totalNet = totalGross / (1 + vat);

        System.out.println("Price without VAT: " + net);
        System.out.println("Price with VAT: " + gross);
        System.out.println("Value with VAT: " + totalGross);
        System.out.println("Value without VAT: " + totalNet);

        // --- Using BigDecimal (correct way) ---
        BigDecimal netBD = new BigDecimal("9.99");
        BigDecimal vatBD = new BigDecimal("0.23");

        BigDecimal onePlusVat = vatBD.add(BigDecimal.ONE);
        BigDecimal grossBD = netBD.multiply(onePlusVat);
        grossBD = grossBD.setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalGrossBD = grossBD.multiply(new BigDecimal("10000"));
        totalGrossBD = totalGrossBD.setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalNetBD = totalGrossBD.divide(onePlusVat, 2, RoundingMode.HALF_UP);

        System.out.println("\nSame thing after using Big Decimal:");
        System.out.println("Price without VAT: " + netBD);
        System.out.println("Price with VAT rounded: " + grossBD);
        System.out.println("Value with VAT: " + totalGrossBD);
        System.out.println("Value without VAT: " + totalNetBD);
    }
}