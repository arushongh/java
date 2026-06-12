/**
 * Decorator Design Pattern allows us to add new functionality to an existing object dynamically without
 * modifying its original class.
 * It is a structural design pattern that uses composition to achieve this.
 * 
 * When do we use it?
 * When we want to add responsibilities to individual objects dynamically and transparently,
 * without affecting other objects
 */
interface Order {
    int cost();
}
class SimpleOrder implements Order{
    public SimpleOrder() {
        System.out.println("Order Placed");
    }
    @Override
    public int cost() {
        return 100;
    }
}

abstract class OrderDecorator implements Order {
    protected Order order;

    public OrderDecorator(Order order) {
        this.order=order;
    }
}

class GiftWrap extends OrderDecorator {
    public GiftWrap(Order order) {
        super(order);
        System.out.println("Gift wrapped");
    }
    @Override
    public int cost() {
        return order.cost()+20;
    }
}

class ExpressDelivery extends OrderDecorator {
    public ExpressDelivery(Order order) {
        super(order);
        System.out.println("Express Delivery");
    }
    @Override
    public int cost() {
        return order.cost()+40;
    }
}

class Insurance extends OrderDecorator {
    public Insurance(Order order) {
        super(order);
        System.out.println("Insurance Added");
    }
    @Override
    public int cost() {
        return order.cost()+29;
    }
}
public class DecoratorDemo {
    public static void main(String[] args) {
        Order order = new ExpressDelivery(new Insurance(new GiftWrap(new SimpleOrder())));
        System.out.println(order.cost());
    }
}
