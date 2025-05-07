package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatSelection(Map<String, List<Object>> diffResult, String formatName) throws Exception {

        return switch (formatName) {
            case "stylish" -> Stylish.formatterStylish(diffResult);
            case "plain" -> Plain.formatterPlain(diffResult);
            case "json" -> Json.formatterJson(diffResult);
            default -> throw new Exception("Incorrect format: " + formatName);
        };
    }
}
