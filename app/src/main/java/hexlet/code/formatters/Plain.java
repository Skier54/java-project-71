package hexlet.code.formatters;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatter(Map<String, List<Object>> diffMap) {
        List<String> resultFile = new LinkedList<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(0);
            var value1 = getValue(values.get(1));
            var value2 = getValue(values.get(2));

            switch (status) {
                case "changed" ->
                        resultFile.add("\nProperty '" + key + "' was updated. From " + value1 + " to " + value2);
                case "deleted" ->
                        resultFile.add("\nProperty '" + key + "' was removed");
                case "added" ->
                        resultFile.add("\nProperty '" + key + "' was added with value: " + value2);
                default -> {

                }
            }
        }
        return String.join("", resultFile);
    }

    public static Object getValue(Object value) {
        if (value instanceof Map || value instanceof List || value instanceof Array) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
