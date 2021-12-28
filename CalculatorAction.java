package com.company.calcium_collision;

public class CalculatorAction {
    private double numberOne;
    private double numberTwo;
    private Sign operator;
    private double result;

    CalculatorAction(double firstNumber, double secondNumber, Sign oper){
        numberOne = firstNumber;
        numberTwo = secondNumber;
        operator = oper;
        calculate();
    }

    public double calculate(){
        switch (operator){
            case PLUS:
                result = numberOne + numberTwo;
                break;

            case MINUS:
                result = numberOne - numberTwo;
                break;

            case DIVIDE:
                result = numberOne / numberTwo;
                break;

            case MULTIPLY:
                result = numberOne * numberTwo;
                break;

        }
        return result;
    }

    @Override
    public String toString(){
        return String.format("%.2f %s %.2f = %.2f", numberOne, operator.getStringValue(), numberTwo, result);
    }

    public double getNumberOne() {
        return numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public Sign getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public void setOperator(Sign operator) {
        this.operator = operator;
    }
}

