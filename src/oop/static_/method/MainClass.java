package oop.static_.method;

public class MainClass {
    
    public static void main(String[] args) {
        
        Count c = new Count();
        int result = c.method1();
        
        int result2 = Count.method2();
        
    }
    
}
