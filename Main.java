package com.company.calcium_collision;

public class Main {

    public static void main(String[] args) {

        double firstNumber = Input.getNumber("Write first number", false);
        Sign sign = Input.getSign();
        double secondNumber;
        if (sign == Sign.DIVIDE) {
            secondNumber = Input.getNumber("Write second number", true);
        } else {
            secondNumber = Input.getNumber("Write first number", false);
        }

        CalculatorAction operation1 = new CalculatorAction(firstNumber, secondNumber, sign);
        System.out.println(operation1.calculate());
        System.out.println(operation1);

    }

}
