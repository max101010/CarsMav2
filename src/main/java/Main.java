import builders.CarBuilder;
import cars.Car;
import cars.Type;
import director.Director;
import park.CarPark;
import park.ParkReader;
import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) {

        //создаем директора
        Director director = new Director();
        CarPark carPark = new CarPark();
        CarPark carPark1 = new CarPark();

        //создаем строителей
        CarBuilder builderTruck = new CarBuilder();
        CarBuilder builderBus = new CarBuilder();
        CarBuilder builderCar = new CarBuilder();

        //выбираем, что будем конструировать
        director.constructTruck(builderTruck);
        director.constructBus(builderBus);
        director.constructCar(builderCar);

        //создаем экземпляр класса

        Car bus = builderBus.getResult(Type.Bus);
        //  bus.addCar();
        Car auto = builderCar.getResult(Type.Auto);
        // auto.addCar();
        Car truck = builderTruck.getResult(Type.Truck);
        //truck.addCar();

        carPark.addCar(bus);
        carPark.addCar(auto);
        carPark.addCar(truck);

        carPark1.addCar(bus);
        carPark1.printAll();
        carPark.printAll();
        carPark.maxPrice();
        carPark.maxSpeed();
//      CarPark.removeCar(truck);
//      CarPark.printAll();

        //вывод на консоль автомобилей из текстового списка
      /*  try {
            ParkReader parkReader = new ParkReader();
            ParkReader.readList();
            for (String s : parkReader.getListReader()) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
      /*
        try {
            ParkReader.readList();
            ParkReader.showList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
    }

}