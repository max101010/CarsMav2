package director;

import builders.Builder;
import properties.Colours;

public class Director {
    /* класс Director управляет созданием автомобиля,
    т.е. что и в какой последовательности создававать*/

    //метод конструирует машину Truk
    public void constructTruck(Builder builder) {
        builder.setModel("MAZ");
        builder.setColour(Colours.WHITE);
        builder.setPrice(50000);
        builder.setSpeed(130);
    }

    //метод конструирует машину Bus
    public void constructBus(Builder builder) {
        builder.setModel("MAN");
        builder.setColour(Colours.BLACK);
        builder.setPrice(130000);
        builder.setSpeed(150);
    }

    //метод конструирует машину Car
    public void constructCar(Builder builder) {
        builder.setModel("BMW");
        builder.setColour(Colours.GREEN);
        builder.setPrice(200000);
        builder.setSpeed(270);
    }
}
