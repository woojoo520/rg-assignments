/*
// Example 1: Eager Singleton
public final class Singleton {
    public static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
*/

/*
// Example 2: Lazy Singleton
public final class Singleton {
    public volatile static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
*/

// Example 3 
public final class Singleton {
    private Singleton() {}
    public static Singleton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final Singleton instance = new Singleton();
    }
}


/*
// Example 4: Enum Class
public enum Singleton {
    INSTANCE;

    public void doSomething() {

    }
}
*/