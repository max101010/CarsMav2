import builders.CarBuilder;
import cars.Car;
import cars.Type;
import director.Director;
import park.CarPark;
import park.ParkReader;
import park.ReaderJson;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is a main class.
 */
public class Main {

    /**
     * Program entry point.
     * @param args command line args
     */
    public static void main(String[] args) {

        //create a director
        Director director = new Director();
        //create a new instance of class CarPark
        CarPark carPark = new CarPark();
        //create a new instance of class CarPark
        CarPark carPark1 = new CarPark();

        //create builders
        CarBuilder builderTruck = new CarBuilder();
        CarBuilder builderBus = new CarBuilder();
        CarBuilder builderCar = new CarBuilder();

        //choose what to design
        director.constructTruck(builderTruck);
        director.constructBus(builderBus);
        director.constructCar(builderCar);

        //create a new car
        Car bus = builderBus.getResult(Type.Bus);
        Car auto = builderCar.getResult(Type.Auto);
        Car truck = builderTruck.getResult(Type.Truck);

        //adds the new cars to the list of carPark
        carPark.addCar(bus);
        carPark.addCar(auto);
        carPark.addCar(truck);

        //adds the new cars to the list of carPark1
        carPark1.addCar(bus);
        carPark1.printAll();
        carPark.printAll();
        carPark.maxPrice();
        carPark.maxSpeed();

        //output the list of cars from the text file
        try {
            ParkReader.readList();
            ParkReader.showList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //reading json file
        ReaderJson.readJson();
        ReaderJson.printMap();
        try {
            ReaderJson.addNewObjects();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReaderJson.printList();
    }

}
