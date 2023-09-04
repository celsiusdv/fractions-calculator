package com.operation.helper;

import java.util.ArrayList;
/*helper class for finding the least common multiple, to make equivalent fractions
* when it's needed specifically to sum and subtract fractions */
public class LCMFinder {
    int denominator1;
    int denominator2;
    int lcm;
    public LCMFinder(int denominator1, int denominator2){
        this.denominator1 = denominator1;
        this.denominator2 = denominator2;
        if(this.denominator1 > this.denominator2){
            //sorting from least to greatest to avoid conflicts below in the loop statement
            int aux=this.denominator2;
            this.denominator2 =this.denominator1;
            this.denominator1 =aux;
        }
        int multiple1= this.denominator1;
        int multiple2= this.denominator2;
        ArrayList<Integer> multiples1= new ArrayList<>();
        ArrayList<Integer> multiples2= new ArrayList<>();

        for(int i = 0; i < (this.denominator1 *this.denominator2); i++){
            multiples1.add(multiple1);//adding the parameter value before it gets multiplied
            multiples2.add(multiple2);//adding the parameter value before it gets multiplied
            multiple1+=this.denominator1;
            multiple2+=this.denominator2;

            for(int j=0; (j < multiples1.size() || j< multiples2.size()); j++){
                if( multiples1.get(i).equals(multiples2.get(j) ) ){
                    this.lcm=multiples2.get(j);//least common multiple
                    i=(this.denominator1 *this.denominator2);//setting i to its full value to break the outer loop
                    break;
                }
            }
        }
/*        System.out.println(multiples1);
        System.out.println(multiples2);
        System.out.println(lcm);*/
    }
    public int getLCM(){
        return this.lcm;
    }
}
