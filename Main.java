package com.company.calcium_collision;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Indicator for all while cycles
        boolean notYet;

        // Pre-initialization
        double firstNumber = 0;
        double secondNumber = 0;
        String signString;
        Sign sign = null;

        //// Accept first number
        notYet = true; // Set on indicator
        System.out.println("Write first number");
        // Will exit out off cycle only if firstNumber will be accepted as number
        while (notYet) {
            try {
                firstNumber = Double.parseDouble(in.nextLine());
                notYet = false; // Indicator off cuz first number is successfully converted to double

            }
            catch (java.lang.NumberFormatException e) {
                System.out.println("Its not number!");
            }

        }

        // Create array with String values of all enum Sign elements
        String[] arraySigns = new String[Sign.values().length];
        for (Sign s: Sign.values()){
            arraySigns[s.ordinal()] = s.getStringValue();
        }

        //// Accept operator
        notYet = true; // Indicator set on
        System.out.printf("Select operator please %s \n", Arrays.toString(arraySigns));
        // Will exit out off cycle only if String will be successfully converted to enum object
        while (notYet){
            signString = in.nextLine();

            // Is exist sign in our early created array true/false
            boolean containSign = Arrays.asList(arraySigns).contains(signString);

            // If sign exist in our early created array
            if (containSign) {
                notYet = false; // Indicator off
                sign = Sign.fromValue(signString); // Converted String to Enum obj
            }
            // If it`s not - one more loop
            else {
                System.out.printf("Please select an operator from this -> %s \n", Arrays.toString(arraySigns));
            }

        }

        //// Accept second number
        notYet = true; // Indicator on
        System.out.println("Write second number");
        /* Will exit out off cycle if secondNumber will be accepted as number
           and it`s not will be division by zero case */
        while (notYet) {
            try {
                secondNumber = Double.parseDouble(in.nextLine());
                // Check on division by zero
                if (sign == Sign.DIVIDE) {
                    if (secondNumber != 0) {
                        notYet = false;
                    } else {
                        System.out.println("Divide by zero is impossible! Try another number.");
                    }
                }
                // If its even not division - straight out of cycle
                else {
                    notYet = false; // Indicator off
                }
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Its not number!");
            }

        }

        CalcOperation operation1 = new CalcOperation(firstNumber, secondNumber, sign);
        System.out.println(operation1.Calculate());
        System.out.println(operation1.toString());

    }

}
