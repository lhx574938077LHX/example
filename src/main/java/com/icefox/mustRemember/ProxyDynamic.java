package com.icefox.mustRemember;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynamic {
    
    public static void main(String[] args) {
        ProxyDynamic proxyDynamic = new ProxyDynamic();
        PersonTest a = proxyDynamic.new PersonTest();
    }

    public interface PersonDao {  
        public void say();  
    }  
    
    public class PersonDaoImpl implements PersonDao{  
        
        @Override  
        public void say() {  
            System.out.println("time to eat");  
        }  
      
    }  
    
    public class PersonHandler implements InvocationHandler {  
        private Object obj;  
        public PersonHandler(Object obj){  
            this.obj=obj;  
        }  
        @Override  
        public Object invoke(Object proxy, Method method, Object[] args)  throws Throwable {  
            System.out.println("before");  
            Object result = method.invoke(obj, args);  
            System.out.println("after");  
            return result;  
        }  
    }  
        
    public class PersonTest {  
        public void test(){  
            PersonDao pDao = new PersonDaoImpl();  
            PersonHandler handler = new PersonHandler(pDao);  
            PersonDao proxy = (PersonDao)Proxy.newProxyInstance(pDao.getClass().getClassLoader(), pDao.getClass().getInterfaces(), handler);  
            proxy.say();  
        }  
    }   
}
