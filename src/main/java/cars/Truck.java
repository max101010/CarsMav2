package cars;

import properties.Colours;

/**
 * This class extends from the class Car and implements it abstract methods.
 */
public class Truck extends Car {

    /**
     * This is constructor and it creates a new instance of class Truck.
     * @param model model car
     * @param colour colour car
     * @param speed speed car
     * @param price price car
     */
    public Truck(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }

    public Truck(){
    }

    @Override
    public String toString() {
        return "cars.Truck{model = " + getModel() + ", colour = " + getColour()
                + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
    }

    @Override
    public void move() {
        System.out.println("normal");
    }

    @Override
    public void beep() {
        System.out.println("normal");
    }
}
