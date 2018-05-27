package cars;

import properties.Colours;

/**
 * This class extends from the class Car and implements it abstract methods.
 */
public class Bus extends Car {

    /**
     * This is constructor and it creates a new instance of class Bus.
     * @param model model car
     * @param colour colour car
     * @param speed speed car
     * @param price price car
     */
    public Bus(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }

    @Override
    public String toString() {
        return "cars.Bus{model = " + getModel() + ", colour = " + getColour()
                + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
    }

    @Override
    public void move() {
        System.out.println("slow");
    }

    @Override
    public void beep() {
        System.out.println("high");
    }

}
