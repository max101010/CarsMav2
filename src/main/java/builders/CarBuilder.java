package builders;

import cars.*;
import properties.Colours;

public class CarBuilder implements Builder {
/*класс Строитель - реализован интерфейс Строитель,
 а также метод который возвращает объект машины в зависимости от выбранного типа */

    private int price;
    private String model;
    private Colours colour;
    private int speed;


    public void setPrice(int price) {
        if (price < 1000 || price > 500000) {
            throw new IllegalArgumentException("price isn't correct");
        }
        this.price = price;
    }


    public void setModel(String model) {
        if (model.matches("[a-zA-Z]+")) { // only letters
            this.model = model;
        } else {
            throw new IllegalArgumentException("model isn't correct");
        }
    }


    public void setColour(Colours colour) {
        this.colour = colour;
    }


    public void setSpeed(int speed) {
        if (speed < 0 || speed > 600) {
            throw new IllegalArgumentException("speed is not correct");
        }
        this.speed = speed;
    }

    //метод возвращает созданный объект в зависимости от выбранного типа машины
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
        }
        return car;
    }
}
