package cars;

import properties.Colours;

public class Truck extends Car {


    public Truck(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }

    @Override
    public String toString() {
        return "cars.Truck{model = " + getModel() + ", colour = " + getColour() + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
    }

    @Override
    public void move() {
        System.out.println("normal");
    }

    public void beep() {
        System.out.println("normal");
    }
}
