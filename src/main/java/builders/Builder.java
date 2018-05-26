package builders;

import properties.Colours;

/**This interface contains methods for the class @see CarBuilder
 * @author Maksim Mikhailau
 * @version 1.0
 */
public interface Builder {

    //метод создает цену машины
    void setPrice(int price);

    //метод создает модель машины
    void setModel(String model);

    //метод создает цвет машины
    void setColour(Colours colour);

    //метод создает скорость машины
    void setSpeed(int speed);
}
