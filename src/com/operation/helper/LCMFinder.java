package com.operation.helper;

import java.util.ArrayList;

public class LCMFinder {
    int param1;
    int param2;
    int lcm;
    public LCMFinder(int param1, int param2){
        this.param1=param1;
        this.param2=param2;
        if(this.param1 > this.param2){
            //sorting from least to greatest to avoid conflicts below in the loop statement
            int aux=this.param2;
            this.param2=this.param1;
            this.param1=aux;
        }
        int multiple1= this.param1;
        int multiple2= this.param2;
        ArrayList<Integer> multiples1= new ArrayList<>();
        ArrayList<Integer> multiples2= new ArrayList<>();

        for(int i=0; i < (this.param1*this.param2); i++){
            multiples1.add(multiple1);//adding the parameter value before it gets multiplied
            multiples2.add(multiple2);//adding the parameter value before it gets multiplied
            multiple1+=this.param1;
            multiple2+=this.param2;

            for(int j=0; (j < multiples1.size() || j< multiples2.size()); j++){
                if( multiples1.get(i).equals(multiples2.get(j) ) ){
                    this.lcm=multiples2.get(j);//least common multiple
                    i=(this.param1*this.param2);//setting i to its full value to break the outer loop
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
