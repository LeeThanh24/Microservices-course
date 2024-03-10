package com.leethanh.;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        double input = 101;


        System.out.println((int) (input )) ;
        double result = input - (int) (input );
        System.out.println((int) (result )) ;
        if (input - (int) (input ) >0 && input >=0 && input <=100 )
        {
            System.out.println(true) ;
        }else {
            System.out.println(false) ;
        }
        Map<String,Integer>  counters= new HashMap<String, Integer>();
        counters.put("A",0);
        counters.put("B",0);
        counters.put("C",0);
        counters.put("D",0);
        counters.put("F",0);

        counters.replace("A", counters.get("F")+1);
        System.out.println(counters.get("F")) ;

    }
}