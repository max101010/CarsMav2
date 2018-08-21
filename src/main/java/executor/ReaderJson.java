package executor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class reads the json file.
 */
public final class ReaderJson {

    private static HashMap<String, JSONObject> testsParams = new HashMap<>();
    private static String filePath = "src/main/resources/testParam.json";

    /**
     * private constructor.
     */
    private ReaderJson() {

    }

    /**
     * This method reads json file.
     */
    private static void readJson() {
        if (testsParams.isEmpty()) {
            try (BufferedReader reader = Files
                    .newBufferedReader(Paths.get(filePath))) {
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                testsParams.putAll(jsonObject);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }



    private static Map<String, Object> getJsonValues(String value) {
        readJson();
        Map<String, Object> result = new HashMap<>();
        result.putAll(testsParams.get(value));
        return result;
    }


    public static Map<String,String> getValue(String values) {
        Map<String,String> result = new HashMap<>();
        Map<String, Object> map = getJsonValues(values);
        StringBuilder allValues = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
           if (entry.getValue() instanceof JSONArray){
               org.json.simple.JSONArray array = (JSONArray) entry.getValue();
               for (Object o : array) {
                   String buffer = (String) o;
                   allValues.append(buffer);
               }
               result.put(entry.getKey(),allValues.toString());
           } else if (entry.getValue() instanceof JSONObject){
              Map<String,String> buff = (Map<String, String>) entry.getValue();
              result.putAll(buff);
           } else
               result.put(entry.getKey(), (String) entry.getValue());

        }
        System.out.println(result);
         return result;
    }

}
//src/main/resources/testParam.json