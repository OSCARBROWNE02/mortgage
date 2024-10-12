package com.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal: ");
        int startPrincipal = scanner.nextInt();
        String currency = NumberFormat.getCurrencyInstance().format(startPrincipal);
        System.out.println("You have: " + currency);

        System.out.println("Annual Interest Rate: ");
        double interestRate = scanner.nextDouble() / PERCENT;
        String interestPercent = NumberFormat.getPercentInstance().format(interestRate);
        System.out.println("With the annual interest rate of: " + (interestRate * PERCENT) + "% OR "  + interestPercent);

        System.out.println("Period(Years): ");
        byte years = scanner.nextByte();
        int months = years * MONTHS_IN_YEAR;
        System.out.println("Over a period of " + years + ", or " + months + "months.");

        System.out.println("Is this information correct? Press Enter to calculate mortgage.");
        String answer = scanner.nextLine();
            if (Objects.equals(answer, "")) {
                double monthlyInterestRate = interestRate / MONTHS_IN_YEAR;
                double onePlusIntRate = (1 + monthlyInterestRate);
                double monthPower = Math.pow(onePlusIntRate, months);
                double mortgageFormula = startPrincipal * (monthlyInterestRate * monthPower) / (monthPower - 1);
                System.out.println("Your monthly mortgage is " + NumberFormat.getCurrencyInstance().format(mortgageFormula));
                System.out.println("This is equivalent to " + NumberFormat.getCurrencyInstance().format(mortgageFormula / 4) + " per week.");
            } else {
                System.out.println("Please Restart");
            }
    }
}
