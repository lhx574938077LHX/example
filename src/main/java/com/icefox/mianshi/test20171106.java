package com.icefox.mianshi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test20171106 {
    
    public static void main(String[] args) {
//        List list = new ArrayList<String>(0);
//        BinaryTree t1 = new BinaryTree();
//        HashMap<String,String> table = new HashMap();
//        System.out.println(table.size());
        double s1 = 0.1d;
        double s2 = 0.9d;
        double s3 = s1+s2;
        System.out.println(s3);
        System.out.println(s1+s2);
        
        BigDecimal d1 = new BigDecimal("0.6");  
        BigDecimal d2 = new BigDecimal("0.4");  
        BigDecimal d3 = d1.divide(d2);  
        System.out.println(d3);  
    }
    
}
