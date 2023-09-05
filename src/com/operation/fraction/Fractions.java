package com.operation.fraction;

import com.operation.helper.Factorizer;
import com.operation.helper.LCMFinder;
import com.operation.helper.Simplifier;

import java.util.Scanner;

public class Fractions {
    Scanner input;
    int[] firstFraction=new int[2];
    int[] secondFraction=new int[2];
    Factorizer factorizeNumerator;
    Factorizer factorizeDenominator;
    Simplifier simplifier;
    LCMFinder lcmFinder;

    public Fractions(){
        input=new Scanner(System.in);
        new LoadFractions(firstFraction,secondFraction,input);
        setOperation();
    }

    public void setOperation(){
        input=new Scanner(System.in);
        System.out.println("select an operation, press a key with any of these symbols '/', '+', '-','*'");
        String symbol=input.nextLine();
        switch (symbol) {
            case "/" -> {
                System.out.println("operation selected: division");
                divideFraction();
            }
            case "+" -> {
                System.out.println("operation selected: addition");
                sumFraction();
            }
            case "*" -> {
                System.out.println("operation selected: multiplication");
                multiplyFraction();

            }
            default -> symbol = "";
        }
        input.close();
    }
    public void divideFraction(){
        int resultNumerator=firstFraction[0]*secondFraction[1];//doing the reciprocal for the division
        int resultDenominator=firstFraction[1]*secondFraction[0];
        System.out.println("non simplified fraction: ["+resultNumerator+"/"+resultDenominator+"]");
        factorizeNumerator = new Factorizer(resultNumerator);//getting the prime factors
        factorizeDenominator=new Factorizer(resultDenominator);
        simplify();
    }
    public void multiplyFraction(){
        int resultNumerator=firstFraction[0]*secondFraction[0];
        int resultDenominator=firstFraction[1]*secondFraction[1];
        System.out.println("non simplified fraction: ["+resultNumerator+"/"+resultDenominator+"]");
        factorizeNumerator = new Factorizer(resultNumerator);//getting the prime factors
        factorizeDenominator=new Factorizer(resultDenominator);
        simplify();
    }

    public void sumFraction() {
        int leftNumerator;
        int rightNumerator;
        int resultNumerator=0;
        int resultDenominator=0;
        if(firstFraction[1] != secondFraction[1]){
            //find the LCM of all denominators
            lcmFinder = new LCMFinder(firstFraction[1], secondFraction[1]);
            //multiplying the numerator by the quotient (LCM ÷ denominator) to get the equivalent fraction
            leftNumerator = firstFraction[0] * (lcmFinder.getLCM() / firstFraction[1]);
            rightNumerator = secondFraction[0] * (lcmFinder.getLCM() / secondFraction[1]);
            //perform the operation with numerators only, place the result over the common denominator
            resultNumerator = leftNumerator + rightNumerator;
            resultDenominator = lcmFinder.getLCM();// <-- common denominator
            System.out.println("non simplified fraction: [" + resultNumerator + "/" + resultDenominator + "], the LCM is: " + lcmFinder.getLCM());
        } else if( firstFraction[1] == secondFraction[1]){
            leftNumerator = firstFraction[0];
            rightNumerator = secondFraction[0];
            resultNumerator = leftNumerator + rightNumerator;
            resultDenominator=firstFraction[1];// <-- common denominator for both fractions
            System.out.println("non simplified fraction: [" + resultNumerator + "/" + resultDenominator + "]");
        }
        factorizeNumerator = new Factorizer(resultNumerator);
        factorizeDenominator=new Factorizer(resultDenominator);
        simplify();
    }

    public void simplify(){
        simplifier= new Simplifier(factorizeNumerator,factorizeDenominator);
        System.out.println("simplified fraction: ["+
                simplifier.getSimplifiedNumerator()+
                "/"+
                simplifier.getSimplifiedDenominator()+"]");
    }

    public static void main(String[] args) {
        new Fractions();
    }
}
