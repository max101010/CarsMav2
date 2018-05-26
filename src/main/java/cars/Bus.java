package cars;

import properties.Colours;

public class Bus extends Car {
/* класс Bus
*/

    public Bus(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }

    @Override
    public String toString() {
        return "cars.Bus{model = " + getModel() + ", colour = " + getColour() + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
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
