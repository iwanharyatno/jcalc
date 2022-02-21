/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jcalc;

/**
 *
 * @author iwanharyatno
 */
public class Calculator {
    public static final int FIRST_NUMBER = 1;
    public static final int SECOND_NUMBER = 2;
    
    private int numState = FIRST_NUMBER;
    private char operation = ' ';
    
    private double firstNumber = 0;
    private double secondNumber = 0;
    
    public void setNumState(int code) {
        this.numState = code;
    }
    
    public int getNumState() {
        return this.numState;
    }
    
    public void setOperation(char operation) {
        this.operation = operation;
    }
    
    public char getOperation() {
        return this.operation;
    }
    
    public void setFirstNumber(double num) {
        this.firstNumber = num;
    }
    
    public void setSecondNumber(double num) {
        this.secondNumber = num;
    }
    
    public double getFirstNumber() {
        return this.firstNumber;
    }
    
    public double getSecondNumber() {
        return this.secondNumber;
    }
    
    public String getSyntax() {
        return this.firstNumber + " " + this.operation + " " + this.secondNumber;
    }
    
    public static boolean isFraction(String numberExpression) {
        return numberExpression.contains(".");
    }
    
    public void reset() {
        this.numState = FIRST_NUMBER;
        this.operation = ' ';
        this.firstNumber = 0;
        this.secondNumber = 0;
    }
    
    public double calculate() throws ArithmeticException {      
        if (numState == FIRST_NUMBER) {
            return firstNumber;
        }
        
        double result = 0;
        
        switch(operation) {
            case '+':
                result = round(firstNumber + secondNumber, 7);
                break;
            case '-':
                result = round(firstNumber - secondNumber, 7);
                break;
            case '*':
                result = round(firstNumber * secondNumber, 7);
                break;
            case '/':
                result = round(firstNumber / secondNumber, 7);
                if (secondNumber == 0) throw new ArithmeticException("Divide by Zero");
                break;
            default:
                result = 0;
                break;
        }
        
        return result;
    }
    
    private double round(double num, int precision) {
        double mulDiv = Math.pow(10, precision);
        return Math.round(num * mulDiv) / mulDiv;
    }
}
