/**
 * Factory design pattern allows us to create objects without exposing the 
 * instantiation logic to the client and refers to the newly created object 
 * through a common interface.
 * 
 * This enables loose coupling.
 * 
 * Read world use case:
 * Payment gateway(Paytm,UPI,Card,NetBanking)
 * Notification service(Email,sms,push)
 * Database connection(mysql,oracle,postgresql)
 * 
 * 
 * If we had used simple if else
 * it would have violated open closed principle as we need to modify existing code 
 * to add new type of car.
 * 
 * When do we use it?
 * When we want to create objects without exposing the instantiation logic to the client.
 */
interface Car {
    void drive();
}
class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Audi");
    }
}
class BMW implements Car {
    @Override
    public void drive() {
        System.out.println("Driving BMW");
    }
}
class CarFactory {
    public static Car getCar(String type) {
        if(type.equalsIgnoreCase("bmw"))
            return new BMW();
        else if(type.equalsIgnoreCase("audi"))
            return new Audi();
        else
            throw new IllegalArgumentException("Unknown car type");
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("bmw");
        car1.drive();
        car1=CarFactory.getCar("audi");
        car1.drive();
    }
}
