package park;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains a list of cars and methods for working with it.
 * the list is filled with input-output streams
 * all methods are static
 */
public class ParkReader {

    /**
     * This is list of all the cars.
     */
    private static List<String> listreader = new ArrayList<String>();
    private static File file = new File("./src/main/resources/Cars.txt");

    /**
     * This method reads text file and adds information to the list.
     * @throws FileNotFoundException signals that an attempt to open the file has failed.
     */
    public static void readList() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {

            while (reader.ready()) {
                String line = reader.readLine();
                listreader.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method returns the list of cars.
     * @return List<String> list of the cars
     */
    public static List<String> getListReader() {
        return Collections.unmodifiableList(listreader);
    }

    /**
     * This method prints the list of cars to the console.
     */
    public static void showList() {
        for (String cars : listreader) {
            System.out.println(cars);
        }
    }
}
