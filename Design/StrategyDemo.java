/**
 * Strategy design pattern is a behavioral design pattern that enables selecting 
 * an algorithm's behavior at runtime. 
 * It defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
 * 
 * When do we use it?
 * When we have multiple algorithms for a specific task and want to switch between them at runtime.
 */
interface RouteStrategy {
    void buildRoute(String from, String to);
}
//implementations of strategies
class WalkingRoute implements RouteStrategy {
    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Building walking route from "+from+" to "+to);
    }
}

class DrivingRoute implements RouteStrategy {
    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Building driving route from "+from+" to "+to);
    }
}

class CyclingRoute implements RouteStrategy {
    @Override
    public void buildRoute(String from, String to) {
        System.out.println("Building cycling route from "+from+" to "+to);
    }
}

class Navigator {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy=routeStrategy;
    }

    public void navigate(String from, String to) {
        routeStrategy.buildRoute(from, to);
    }
}
public class StrategyDemo {
    public static void main(String[] args) {
        Navigator navigator=new Navigator();
        navigator.setRouteStrategy(new CyclingRoute());
        navigator.navigate("hyderabad", "jamshedpur");

        navigator.setRouteStrategy(new DrivingRoute());
        navigator.navigate("hyderabad", "jamshedpur");

        
    }
}
