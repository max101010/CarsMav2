package cars;

import properties.Colours;

public class Auto extends Car {
    public Auto(String model, Colours colour, int speed, int price) {
        super(model, colour, speed, price);
    }
    @Override
    public String toString() {
        return "cars.Auto{model = " + getModel() + ", colour = " + getColour() + ", speed = " + getSpeed() + ", price = " + getPrice() + "}";
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
