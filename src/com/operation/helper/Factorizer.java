package com.operation.helper;

import java.util.ArrayList;
/**
* Algorithm to extract prime factors from a given number.
*   Use this class individually to check the factors and
*   uncomment all the commented lines to use this class
*   as a utility in any main method.
**/
public class Factorizer {
    ArrayList<Integer> primeFactors;
    int number;
    public Factorizer(int number) {
        primeFactors = new ArrayList<>();
        this.number = number;
        int primeFactor = 1;
        int result;

        while (primeFactor < this.number) {
            result = this.number / primeFactor;
            if ((result * primeFactor) == this.number) {
                //System.out.println("result: "+result+", prime factor: "+primeFactor);
                primeFactors.add(primeFactor);
                this.number = result;
                primeFactor = 1;
                //System.out.println("next number to be factorized -> "+this.number+"\n");
            }
            primeFactor++;
        }
        primeFactors.add(this.number);//add the last prime factor

/*        this.number=1;//setting to 1 to accumulate all the prime factors
        primeFactors.forEach((factor) -> {
            this.number*=factor;//checking if all the prime factors gives the correct product (the factorized number)
            if(factor != 1)System.out.print("["+factor+"]");
            else System.out.println("prime factors:");
        });
        System.out.println("\nthe factored number: "+this.number);*/
    }
    public ArrayList<Integer> getPrimeFactors() {
        return this.primeFactors;
    }
}
