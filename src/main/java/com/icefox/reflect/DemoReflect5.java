package com.icefox.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DemoReflect5 {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("com.icefox.reflect.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        //全部以方法名为主，进行查找
        //方法名
        Method method[]=demo.getMethods();
        for(int i=0;i<method.length;++i){
        	//返回类型
            Class<?> returnType=method[i].getReturnType();
            //传入参数
            Class<?> para[]=method[i].getParameterTypes();
            int temp=method[i].getModifiers();
            System.out.print(Modifier.toString(temp)+" ");
            System.out.print(returnType.getName()+"  ");
            System.out.print(method[i].getName()+" ");
            System.out.print("(");
            for(int j=0;j<para.length;++j){
                System.out.print(para[j].getName()+" "+"arg"+j);
                if(j<para.length-1){
                    System.out.print(",");
                }
            }
            //抛出异常
            Class<?> exce[]=method[i].getExceptionTypes();
            if(exce.length>0){
                System.out.print(") throws ");
                for(int k=0;k<exce.length;++k){
                    System.out.print(exce[k].getName()+" ");
                    if(k<exce.length-1){
                        System.out.print(",");
                    }
                }
            }else{
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
