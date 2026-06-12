/**
 * Abstract Factory Design Pattern is a creational design pattern that provides an interface 
 * for creating families of related objects without specifying their concrete classes.
 * 
 * 
 * Real world use case:
 * GUI toolkit that supports multiple operating systems (Windows, MacOS, Linux)
 * 
 * When do we use it?
 * When we want to create families of related objects without specifying their concrete classes,
 * 
*/
interface Button {
    void renderButton();
}
interface Checkbox {
    void renderCheckbox();
}

class WindowsButton implements Button {
    @Override
    public void renderButton() {
        System.out.println("Rendering Windows Button");
    }
}
class WindowsCheckbox implements Checkbox {
    @Override
    public void renderCheckbox() {
        System.out.println("Rendering Windows Checkbox");
    }
}
class MacOSButton implements Button {
    @Override
    public void renderButton() {
        System.out.println("Rendering MacOS Button");
    }
}
class MacOSCheckbox implements Checkbox {
    @Override
    public void renderCheckbox() {
        System.out.println("Rendering MacOS Checkbox");
    }
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();

}
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
class LaptopUI {
    public static GUIFactory getLaptopUI(String type) {
        if(type.equalsIgnoreCase("windows"))
            return new WindowsFactory();
        else if(type.equalsIgnoreCase("mac"))
            return new MacFactory();
        throw new IllegalArgumentException("Enter valid type");
    }
}
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory = LaptopUI.getLaptopUI("windows");
        
        Button wButton=factory.createButton();
        Checkbox wCheckbox=factory.createCheckbox();
        wButton.renderButton();
        wCheckbox.renderCheckbox();
    }
}
