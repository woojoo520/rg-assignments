package org.example;

interface TestStaticInterface {
    public void square(int a);
    static void show() {
        System.out.println("Static method executed.");
    }
}

class TestStaticClass implements TestStaticInterface {

    @Override
    public void square(int a) {
        System.out.println(a * a);
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        TestStaticClass d = new TestStaticClass();
        d.square(10);

        TestStaticInterface.show();
    }
}
