package com.company.calcium_collision;

import java.util.Arrays;
import java.util.Scanner;

public class Input {

    private static final Scanner in = new Scanner(System.in);
    private static boolean notReady;
    private static String[] arraySigns = new String[Sign.values().length];
    static {
        for (Sign s: Sign.values()){
            arraySigns[s.ordinal()] = s.getStringValue();
        }
    }

    public static double getNumber(String message, boolean withoutZero){
        notReady = true;
        double number = 0;
        while (notReady){
            try {
                System.out.println(message);
                number = Double.parseDouble(in.nextLine());
                if (withoutZero && number == 0){
                    System.out.println("Divide by zero is impossible! Try another number.");
                } else {
                    notReady = false;
                }
            } catch (java.lang.NumberFormatException e){
                System.out.println("Its not number! Try again.");
            }
        }
        return number;
    }

    public static Sign getSign(){
        String signString;
        Sign sign = null;
        notReady = true;
        System.out.printf("Select operator please %s \n", Arrays.toString(arraySigns));

        // Will exit out off cycle only if String will be successfully converted to enum object
        while (notReady){
            signString = in.nextLine();

            // Is exist sign in our early created array true/false
            boolean containSign = Arrays.asList(arraySigns).contains(signString);

            // If sign exist in our early created array
            if (containSign) {
                notReady = false; // Indicator off
                sign = Sign.fromValue(signString); // Converted String to Enum obj
            }
            // If it`s not - one more loop
            else {
                System.out.printf("Please select an operator from this -> %s \n", Arrays.toString(arraySigns));
            }

        }
        return sign;
    }
}
