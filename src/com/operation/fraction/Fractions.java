package com.operation.fraction;

import com.operation.helper.Factorizer;
import com.operation.helper.Simplifier;

import java.util.Scanner;

public class Fractions {
    Scanner input;
    int[] firstFraction=new int[2];
    int[] secondFraction=new int[2];
    Factorizer factorizeNumerator;
    Factorizer factorizeDenominator;
    Simplifier simplifier;

    public Fractions(){

        input=new Scanner(System.in);
        new LoadFractions(firstFraction,secondFraction,input);
        setOperation();
    }

    public void setOperation(){
        input=new Scanner(System.in);
        System.out.println("select an operation, press any of these symbols '/', '+', '-','*'");
        String symbol=input.nextLine();
        switch (symbol) {
            case "/" -> {
                System.out.println("operation selected: division");
                divideFraction();
            }
            case "+" -> {
                System.out.println("operation selected: addition");
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
    public void sumFraction(){

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
