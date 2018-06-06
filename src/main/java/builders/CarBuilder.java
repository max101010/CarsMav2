package builders;

import cars.*;
import properties.Colours;

/**
 * CarBuilder implementation of Builder interface.
 */
public class CarBuilder implements Builder {

    /**
     * Parameters for the car.
     */
    private int price;
    private String model;
    private Colours colour;
    private int speed;

    /**
     * Implements the interface Builder.
     * This method sets the price of the car between minPrice and maxPrice
     * @param price car price
     */
    public void setPrice(int price) {
       final int minPrice = 1000;
       final int maxPrice = 500000;
        if (price < minPrice || price > maxPrice) {
            throw new IllegalArgumentException("price isn't correct");
        }
        this.price = price;
    }

    /**
     * Implements the interface Builder.
     * This method sets the model of the car
     * @param model car model
     */
    public void setModel(String model) {
        if (model.matches("[a-zA-Z]+")) { // only letters
            this.model = model;
        } else {
            throw new IllegalArgumentException("model isn't correct");
        }
    }

    /**
     * Implements the interface Builder.
     * This method sets colour of the car
     * @param colour car colour
     */
    public void setColour(Colours colour) {
        this.colour = colour;
    }

    /**
     * Implements the interface Builder.
     * This method sets speed of the car between 0 and 600
     * @param speed car speed
     */
    public void setSpeed(int speed) {
        final int minSpeed = 30;
        final int maxSpeed = 600;
        if (speed < minSpeed || speed > maxSpeed) {
            throw new IllegalArgumentException("speed is not correct");
        }
        this.speed = speed;
    }

    /**
     * This method returns a new child instance of the class Car.
     * @param type type of car
     * @return car
     */
    public Car getResult(Type type) {
        Car car = null;
        switch (type) {
            case Bus:
                car = new Bus(model, colour, speed, price);
                break;
            case Auto:
                car = new Auto(model, colour, speed, price);
                break;
            case Truck:
                car = new Truck(model, colour, speed, price);
                break;
                default:
                    throw new IllegalArgumentException("type isn't correct");
        }
        return car;
    }

}
