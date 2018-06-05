package park;

import cars.Auto;
import cars.Bus;
import cars.Car;
import cars.Truck;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import properties.Colours;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReaderJson {
   private static HashMap<String, JSONObject> carsMap = new HashMap<>();
   private  static String filename = "./src/main/resources/cars_js.json";
   private static List<Car>carsList = new ArrayList<>();
    private static JSONObject jsonObject;
   private static int count = 0;
    private static JSONObject valuesObj;
    public static void readJson() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(reader);
            carsMap.putAll(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void printMap (){
        for (Map.Entry<String,JSONObject> item : carsMap.entrySet() ){

            System.out.println(item);
        }
    }

    public static void addNewObjects() throws IOException {
        for (Map.Entry<String, JSONObject> entry : carsMap.entrySet()) {
            String key = entry.getKey();
            JSONObject values = entry.getValue();
            String str = String.valueOf(values);
            if (key.equals("Bus")) {
                System.out.println("create new instance Bus");
                int countOb = countFor(str);
                for (int i = 0; i < countOb; i++) {
                    String nameOb = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    valuesObj = (JSONObject) entry.getValue().get(nameOb);
                    carsList.add(new Bus());
                    switchColour();
                    setParam();
                    count++;
                }
            } else
                if (key.equals("Truck")){
                    System.out.println("create new instance Truck");
                    int countOb = countFor(str);
                    for (int i = 0; i < countOb; i++) {
                        String nameOb = new BufferedReader(new InputStreamReader(System.in)).readLine();
                        valuesObj = (JSONObject) entry.getValue().get(nameOb);
                        carsList.add(new Truck());
                        switchColour();
                        setParam();
                        count++;
                    }
                } else
                    if (key.equals("Auto")){
                        System.out.println("create new instance Auto");
                        int countOb = countFor(str);
                        for (int i = 0; i < countOb; i++) {
                            String nameOb = new BufferedReader(new InputStreamReader(System.in)).readLine();
                            valuesObj = (JSONObject) entry.getValue().get(nameOb);
                            carsList.add(new Auto());
                            switchColour();
                            setParam();
                            count++;
                        }
                    }
        }
    }

public static void printList(){
    for (Car car : carsList) {
        System.out.println(car);
    }
}

private static void switchColour() {
    String colour = (String) valuesObj.get("colour");
    switch (colour) {
        case "yellow":
            carsList.get(count).setColour(Colours.YELLOW);
            break;
        case "green":
            carsList.get(count).setColour(Colours.GREEN);
            break;
        case "black":
            carsList.get(count).setColour(Colours.BLACK);
            break;
        case "white":
            carsList.get(count).setColour(Colours.WHITE);
            break;
        case "orange":
            carsList.get(count).setColour(Colours.ORANGE);
            break;
        case "blue":
            carsList.get(count).setColour(Colours.BLUE);
            break;
        default:
            System.out.println("colour is false");
            break;

    }
}

    private static void setParam(){
        int speed = Integer.parseInt(String.valueOf(valuesObj.get("speed")));
        int price = Integer.parseInt(String.valueOf(valuesObj.get("price")));
        String model = (String) valuesObj.get("model");
        carsList.get(count).setParameters(price, model, speed);
    }

    private static int countFor(String str){
        String[] words = str.toLowerCase().replaceAll("[-.?!}{,:]", " ").split("\\s");
        int countOb = 0;
        for (String s : words) {
            System.out.println(s);
            if (s.contains("model")) {
                countOb++;
            }
        }
        return countOb;
    }

}

