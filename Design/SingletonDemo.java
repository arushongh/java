/**
 * Singleton is a design pattern that restricts the instantiation of a class to a single
 * object and provides a global point of access to that object. This is useful when exactly one
 * object is needed to coordinate actions across the system.
 * 
 * Real world use case:
 * Logger class in which multiple threads can write to the same log file, so we need only one instance of logger class.
 * database connection class in which we want to maintain a single connection to the database.
 * 
 * 
 */
class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    //not thread safe

    // public static Singleton getInstance() {
    //     if(singleton==null)
    //         singleton=new Singleton();
    //     return singleton;
    // }

    //thread safe with double locking
    /**
     * It does not prevent reflection attack, to correct that we can throw exception in constructor if instance is already created.
     * It does not prevent serialization attack, to correct that we can implement readResolve method to return the same instance.
     */
    public static Singleton getInstance() {
        if(singleton==null) {
            synchronized(Singleton.class) {
                if(singleton==null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
/**
 * Enum does all
 * 1. It is thread safe.
 * 2. It prevents reflection attack.
 * 3. It prevents serialization attack.
 */
enum SingletonBest {
    INSTANCE;
}
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);

        SingletonBest b1=SingletonBest.INSTANCE;
        SingletonBest b2=SingletonBest.INSTANCE;
        System.out.println(b1==b2);
    }
    
}
