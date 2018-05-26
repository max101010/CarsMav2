package park;

import org.apache.commons.collections4.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkReader {
/*
класс ParkReader - класс, задача которого
работа с текстовым документо, т.е. считывание списка машин,
вывод на консоль списка
 */

    private static List<String> listreader = new ArrayList<String>();
    private static File file = new File("./src/Cars.txt");


    //метод считывает список машин с текстового файла
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

    //метод возвращает список машин, который считали
    public static List<String> getListReader() {
        return Collections.unmodifiableList(listreader);
    }
    public static void showList(){
        for (String cars : listreader){
            System.out.println(cars);
        }
    }
}
