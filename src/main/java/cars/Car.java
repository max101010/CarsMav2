package cars;

import properties.Colours;

/*
 * This is an abstract class that represents an algorithm for creating a car.
 */
public abstract class Car {

    private int price;
    private String model;
    private Colours colour;
    private int speed;

    public Car(String model, Colours colour, int speed, int price) {
        this.model = model;
        this.colour = colour;
        this.speed = speed;
        this.price = price;
    }

    //метод возвращает поле model
    protected String getModel() {
        return model;
    }

    //метод возвращает поле colour
     protected Colours getColour() {
        return colour;
    }

    //метод возвращает поле speed
    public int getSpeed() {
        return speed;
    }

    //метод возвращает поле price
    public int getPrice() {
        return price;
    }


    public abstract void move();

    public abstract void beep();
}
