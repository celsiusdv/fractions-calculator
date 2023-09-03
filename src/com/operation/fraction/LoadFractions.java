package com.operation.fraction;

import java.util.Scanner;

public class LoadFractions {
    public LoadFractions(int[] firstFraction, int[] secondFraction, Scanner input){
        System.out.print("set the first fraction\n\tintroduce the numerator:");
        firstFraction[0]=input.nextInt();
        System.out.print("  introduce the denominator:");
        firstFraction[1]=input.nextInt();

        System.out.print("set the second fraction\n\tintroduce the numerator:");
        secondFraction[0]=input.nextInt();
        System.out.print("  introduce the denominator:");
        secondFraction[1]=input.nextInt();
    }
}
