package com.access.one;

public class Base {
    public void publicMethod() {
        System.out.println("Public: Accessible from anywhere.");
    }

    protected void protectedMethod() {
        System.out.println("Protected: Accessible in same package OR subclasses.");
    }

    void defaultMethod() {
        System.out.println("Default: Accessible only within the same package.");
    }

    private void privateMethod() {
        System.out.println("Private: Accessible only within this class.");
    }
}
package com.access.two;

import com.access.one.Base;

public class Derived extends Base {
    public void testAccess() {
        System.out.println("--- Testing Access from Subclass in Different Package ---");
        publicMethod(); 
        protectedMethod(); 
    }
}