package com.operation.helper;

import java.util.Arrays;

public class Simplifier {
    int[] numerator;
    int[] denominator;

    public Simplifier(Factorizer factorizeNumerator, Factorizer factorizeDenominator) {
        this.loadNumeratorAndDenominator(factorizeNumerator, factorizeDenominator);
        //System.out.println("cancelling common factors between the numerator and denominator:");
        this.cancelNumeratorAndDenominator();
        //System.out.println(Arrays.toString(this.numerator));
        //System.out.println(Arrays.toString(this.denominator));
    }

    public void loadNumeratorAndDenominator(Factorizer factorizeNumerator,
                                            Factorizer factorizeDenominator) {
        this.numerator = new int[factorizeNumerator.getPrimeFactors().size()];
        this.denominator = new int[factorizeDenominator.getPrimeFactors().size()];

        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = factorizeNumerator.getPrimeFactors().get(i);
        }
        for (int i = 0; i < denominator.length; i++) {
            denominator[i] = factorizeDenominator.getPrimeFactors().get(i);
        }
    }
    public void cancelNumeratorAndDenominator(){
        //choosing the least range of iteration to replace values in the array to simplify
        int limit1;
        int limit2;
        if (this.numerator.length > this.denominator.length){
            limit1 = this.denominator.length;
            limit2=this.numerator.length;
        }
        else{
            limit1 = this.numerator.length;
            limit2=this.denominator.length;
        }
        /*cancelling with 0 the common factors between the numerator and denominator instead of deleting it.
        * non cancelled values will be multiplied in the two methods from below:
        * getSimplifiedNumerator(), getSimplifiedDenominator() */
        for (int i = 0; i < limit1; i++) {
            for( int j=0; j < limit2; j++){
                if (this.numerator[i] == this.denominator[j]) {
                    this.numerator[i] = 0;
                    this.denominator[j] = 0;
                }
            }
        }
    }
    /*these two methods multiplies from greatest to least all the non cancelled values
    * to get the simplified value for the numerator and the denominator*/
    public int getSimplifiedNumerator() {
        int simplifiedNumerator=1;
        for(int i=numerator.length-1; i>=0; i--){
            if(numerator[i] > 0) simplifiedNumerator*=numerator[i];
        }
        return simplifiedNumerator;
    }
    public int getSimplifiedDenominator() {
        int simplifiedDenominator=1;
        for(int i=denominator.length-1; i>=0; i--){
            if(denominator[i] > 0) simplifiedDenominator*=denominator[i];
        }
        return simplifiedDenominator;
    }
}