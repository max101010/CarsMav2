package park;

import cars.Car;
import org.apache.commons.collections4.CollectionUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarPark {
/*класс CarPark - класс, задача которого работа
со списком всех автомобилей
 */

    private List<Car> allcars = new ArrayList<Car>();

    //метод возвращает список все машин
    public List<Car> getAllcars() {
        return Collections.unmodifiableList(allcars);
    }

    //метод выводит на консоль все машины из списка
    public void printAll() {
        if (CollectionUtils.size(allcars) < 1) {
            System.out.println("list is empty");
        } else
            for (Car allcar : allcars) {
                System.out.println(allcar);
            }
    }

    //метод добавляет машину в список
    public void addCar(Car car) {
        allcars.add(car);
    }

    //метод удаляет машину из списка
    public void removeCar(Car car) {
        allcars.remove(car);
    }

    //метод находит машину из списка всех машин с максимальной скоростью и выводит на консоль
    public void maxSpeed() {
        if (CollectionUtils.size(allcars)>0) {
            Collections.sort(allcars, new Comparator<Car>() {

                public int compare(Car o1, Car o2) {
                    return o2.getSpeed() - o1.getSpeed();
                }
            });
            System.out.println("maxSpeed = " + allcars.get(0));
        }else {
            System.out.println("list is empty");
        }
    }

    //метод находит машину из списка всех машин с максимальной ценой и выводит на консоль
    public void maxPrice() {
        if (CollectionUtils.size(allcars)>0) {
            Collections.sort(allcars, new Comparator<Car>() {

                public int compare(Car o1, Car o2) {
                    return o2.getPrice() - o1.getPrice();
                }
            });

            System.out.println("maxPrice = " + allcars.get(0));
        } else {
            System.out.println("list is empty");
        }
    }

}
