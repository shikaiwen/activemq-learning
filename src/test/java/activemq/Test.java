package activemq;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {

    interface hello {  
        String sayHello(String name);  
    }  
          
    public static void count(){
    	Integer [] arr = (Integer [])Arrays.asList(1,2,6,33,22,75,3 ).toArray();
    	Stream stream = Stream.of(arr);
//    	int result = stream.filter(predicate)
    }
    
    public static void main(String[]args){  

    	Stream stream = Stream.of(1,2,3);
    	
    	
    	String prefix = "p "; 
    	final String myPrefix = prefix;
    	Arrays.asList("1","2","3").forEach( (String e)-> System.out.println( myPrefix + e) );
    	prefix += "pp";
    	System.out.println(prefix);
//        hello he = (String name) -> {  
//            int y = 1;  
//            String hello = "hello, " + name;  
//            return hello;  
//            };  
//        System.out.println(he.sayHello("kevin "));  
    }   
}
