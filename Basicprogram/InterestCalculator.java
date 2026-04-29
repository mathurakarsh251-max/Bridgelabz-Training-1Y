package com.bank.util;
import static java.lang.Math.*;

public class InterestCalculator {
    public double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }
    public double calculateCompoundInterest(double p, double r, double t) {
        return p * pow((1 + r / 100), t) - p;
    }
}
import com.bank.util.InterestCalculator;

public class BankApp {
    public static void main(String[] args) {
        InterestCalculator calc = new InterestCalculator();

        double principal = 10000.0; 
        double rate = 7.5;          
        double time = 3.0;          
        double si = calc.calculateSimpleInterest(principal, rate, time);
        double ci = calc.calculateCompoundInterest(principal, rate, time);

        System.out.println("--- Banking Interest Report ---");
        System.out.println("Principal Amount: ₹" + principal);
        System.out.println("Annual Interest Rate: " + rate + "%");
        System.out.println("Duration: " + time + " years");
        System.out.println("-------------------------------");
        
        System.out.printf("Simple Interest: ₹%.2f\n", si);
        System.out.printf("Compound Interest: ₹%.2f\n", ci);
        System.out.printf("Total Amount (CI): ₹%.2f\n", (principal + ci));
    }
}