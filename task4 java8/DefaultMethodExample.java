package org.example;

interface TestInterface {
    public void square(int a);
    default void show() {
        System.out.println("Default method executed");
    }
}

class TestClass implements TestInterface {

    @Override
    public void square(int a) {
        System.out.println(a * a);
    }
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.square(10);
        t.show();
    }
}
