package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatSelection(Map<String, List<Object>> diffMap, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> Stylish.formatter(diffMap);
            case "plain" -> Plain.formatter(diffMap);
            case "json" -> Json.formatter(diffMap);
            default -> throw new Exception("Incorrect format: " + formatName);
        };
    }
}
