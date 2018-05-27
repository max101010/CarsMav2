package builders;

import properties.Colours;

/**
 * Builder interface for the class CarBuilder.
 */
public interface Builder {

    /**
     * This method sets the price for the car.
     * @param price car price
     */
    void setPrice(int price);

    /**
     * This method sets the model for the car.
     * @param model car model
     */
    void setModel(String model);

    /**
     * This method sets the colour for the car.
     * @param colour car colour
     */
    void setColour(Colours colour);

    /**
     * This method sets speed for the car.
     * @param speed car speed
     */
    void setSpeed(int speed);

}
