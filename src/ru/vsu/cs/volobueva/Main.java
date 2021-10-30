package ru.vsu.cs.volobueva;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = checkCorrectAndReadDoubleX();

        int n = checkCorrectAndReadInt();

        double e = readDouble();

        double sum1 = calculateSumOfMembersGreaterValue(n, 0, x);
        double sumE = calculateSumOfMembersGreaterValue(n, e, x);
        double sumE10 = calculateSumOfMembersGreaterValue(n, e/10, x);
        double valueFunctionMath = calculateFunctionValue(x);

        printCalculationResults(sum1, sumE, sumE10, valueFunctionMath);
    }

    static int checkCorrectAndReadInt() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a value n: ");
        int value = scanner.nextInt();

        if (value <= 0) {
            System.out.println("Error: invalid parameter value n.");
            value = checkCorrectAndReadInt();
        }
        return value;
    }

    static double readDouble() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a value e: ");

        return scanner.nextDouble();
    }

    static double checkCorrectAndReadDoubleX() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a value x: ");
        double variable = scanner.nextDouble();

        if (Math.abs(variable) >= 1) {
            System.out.println("Error: invalid parameter value x. By the condition -1 < x < 1.");
            variable = checkCorrectAndReadDoubleX();
        }
        return variable;
    }

    static double calculateSumOfMembersGreaterValue(int n, double value, double x) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double member = Math.pow(-3, i) * Math.pow(x, i);
            if (Math.abs(member) > value) {
                sum += member;
            }
        }
        return sum;
    }

    static double calculateFunctionValue(double x) {
        return 1 / (1 + 3 * x);
    }

    static void printCalculationResults(double sum1, double sumE, double sumE10, double valueFunctionMath) {
        System.out.println("The sum of n terms of the sequence: sum1 = " + sum1);
        System.out.println("The sum of the terms of the sequence greater than e: sumE = " + sumE);
        System.out.println("The sum of the terms of the sequence greater than e/10: sumE10 = " + sumE10);
        System.out.println("Function value: sumMath = " + valueFunctionMath);
    }
}
