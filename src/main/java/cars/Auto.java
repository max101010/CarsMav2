package cars;

import properties.Colours;

/**
 * This class extends from the class Car and implements it abstract methods.
 */
public class Auto extends Car {

    /**
     * This is constructor and it creates a new instance of class Auto.
     *
     * @param model  model car
     * @param colour colour car
     * @param speed  speed car
     * @param price  price car
     */
    public Auto(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }

    /**
     * Default constructor.
     */
    public Auto() {

    }

    @Override
    public String toString() {
        return "cars.Auto{model = " + getModel() + ", colour = " + getColour()
                + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
    }

    @Override
    public void move() {
        System.out.println("move fast");
    }

    @Override
    public void beep() {
        System.out.println("low");
    }

}
