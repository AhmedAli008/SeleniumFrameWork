package Utilities;

import Config.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    public static JSONObject getJsonDataByTitle(String filePath, String testCaseTitle) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray testArray = (JSONArray) obj;

            System.out.println("Searching for test case: " + testCaseTitle);

            // Find the test case with the matching testCaseTitle
            for (Object testObject : testArray) {
                JSONObject testCase = (JSONObject) testObject;
                if (testCaseTitle.equals(testCase.get("testCaseTitle"))) {  // Null-safe comparison
                    System.out.println("Found test case: " + testCase); // Debugging log
                    return testCase;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("JSON file not found: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return null if no matching test case is found
        System.err.println("No test case found for title: " + testCaseTitle);
        return null;
    }
    public static void saveAttributeToJson(String filePath, String attributeName, Object value) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the existing JSON file into an ObjectNode (for easy modification)
            File file = new File(filePath);
            ObjectNode jsonNode;

            if (file.exists()) {
                // If file exists, read it and load into ObjectNode
                jsonNode = (ObjectNode) objectMapper.readTree(file);
            } else {
                // If file does not exist, create a new ObjectNode
                jsonNode = objectMapper.createObjectNode();
            }

            // Set or update the specified attribute
            jsonNode.putPOJO(attributeName, value);

            // Write the updated JSON back to the file with pretty printing
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonNode);

            System.out.println("Attribute saved successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void  saveSSCCNumberToJson(String SSCCserial) {
        saveAttributeToJson(Properties.CREATED_SSCC_PATH,"SSCCserial", SSCCserial);
    }
    public static String GetSSCCserialfromjsonlist () {

        Map<String, Object> obj = getJsonData(Properties.CREATED_SSCC_PATH);
        return (String) obj.get("SSCCserial");
    }

    public static Map<String, Object> getJsonData(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(jsonFilePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
