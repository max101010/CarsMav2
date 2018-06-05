package park;

import cars.Car;
import org.apache.commons.collections4.CollectionUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains a list of cars and methods for working with it.
 */
public class CarPark {

    /**
     * This is list of all the cars.
     */
    private List<Car> allcars = new ArrayList<Car>();

    /**
     * This method returns the list of cars.
     * @return List<Car> list of the cars
     */
    public List<Car> getAllcars() {
        return Collections.unmodifiableList(allcars);
    }

    /**
     * This method prints the list of cars to the console.
     */
    public void printAll() {
        if (CollectionUtils.isEmpty(allcars)) {
            System.out.println("list is empty");
        } else {
            for (Car allcar : allcars) {
                System.out.println(allcar);
            }
        }
    }

    /**
     * This method adds the car to the list.
     * @param car car of one of the types
     */
    public void addCar(Car car) {
        allcars.add(car);
    }

    /**
     * This method deletes the car to the list.
     * @param car car of one of the types
     */
    public void removeCar(Car car) {
        allcars.remove(car);
    }

    /**
     * This method displays the fastest car.
     */
    public void maxSpeed() {
        if (CollectionUtils.size(allcars) > 0) {
            Collections.sort(allcars, new Comparator<Car>() {

                public int compare(Car o1, Car o2) {
                    return o2.getSpeed() - o1.getSpeed();
                }
            });
            System.out.println("maxSpeed = " + allcars.get(0));
        } else {
            System.out.println("list is empty");
        }
    }

    /**
     * This method displays the most expensive car.
     */
    public void maxPrice() {
        if (CollectionUtils.size(allcars) > 0) {
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
