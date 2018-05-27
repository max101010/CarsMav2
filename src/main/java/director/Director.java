package director;

import builders.Builder;
import properties.Colours;

/**
 * This class manages the creation of a car.
 */
public class Director {

    /**
     * This method constructs the truck.
     * @param builder object of the interface builder
     */
    public void constructTruck(Builder builder) {
        final int price = 50000;
        final int speed = 130;
        builder.setModel("MAZ");
        builder.setColour(Colours.WHITE);
        builder.setPrice(price);
        builder.setSpeed(speed);
    }

    /**
     * This method constructs the bus.
     * @param builder object of the interface builder
     */
    public void constructBus(Builder builder) {
        final int price = 130000;
        final int speed = 150;
        builder.setModel("MAN");
        builder.setColour(Colours.BLACK);
        builder.setPrice(price);
        builder.setSpeed(speed);
    }

    /**
     * This method constructs the car.
     * @param builder object of the interface builder
     */
    public void constructCar(Builder builder) {
        final int price = 200000;
        final int speed = 270;
        builder.setModel("BMW");
        builder.setColour(Colours.GREEN);
        builder.setPrice(price);
        builder.setSpeed(speed);
    }
}
