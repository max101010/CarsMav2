package cars;

import properties.Colours;

/**
 * This is an abstract class that represents an algorithm for creating a car.
 */
public abstract class Car {

    //Values for the car
    private int price;
    private String model;
    private Colours colour;
    private int speed;

    /**
     * Constructor for the car.
     *
     * @param model  model car
     * @param colour colour car
     * @param speed  speed car
     * @param price  price car
     */
    public Car(String model, Colours colour, int speed, int price) {
        this.model = model;
        this.colour = colour;
        this.speed = speed;
        this.price = price;
    }

    /**
     * Default constructor.
     */
    public Car() {

    }

    /**
     * This method returns the model of car.
     *
     * @return model
     */
    protected String getModel() {
        return model;
    }

    /**
     * This method returns the colour of car.
     *
     * @return colour
     */
    protected Colours getColour() {
        return colour;
    }

    /**
     * This method returns the speed of car.
     *
     * @return colour
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * This method returns the price of car.
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * This is an abstract method for driving a car.
     */
    public abstract void move();

    /**
     * This is an abstract method for the signal car.
     */
    public abstract void beep();

    /**
     * This is method for the class ReaderJson.
     * It sets price, model, speed
     * @param price price car
     * @param model model car
     * @param speed speed car
     */
    public void setParameters(int price, String model, int speed) {
        this.price = price;
        this.speed = speed;
        this.model = model;
    }

    /**
     * This is method for the class ReaderJson.
     * it sets colour
     * @param colour colour car
     */
    public void setColour(Colours colour) {
        this.colour = colour;
    }
}
