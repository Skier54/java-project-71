package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static final int ELEMENT_STATUS = 0;
    public static final int FIRST_VALUE = 1;
    public static final int SECOND_VALUE = 2;

    public static String formatterStylish(Map<String, List<Object>> diffMap) {
        StringBuilder resultFile = new StringBuilder("{\n");

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(ELEMENT_STATUS);
            var valueOld = values.get(FIRST_VALUE);
            var valueNew = values.get(SECOND_VALUE);

            switch (status) {
                case "unchanged" ->
                    resultFile.append("    ").append(key).append(": ").append(valueOld).append("\n");
                case "changed" -> {
                    resultFile.append("  - ").append(key).append(": ").append(valueOld).append("\n");
                    resultFile.append("  + ").append(key).append(": ").append(valueNew).append("\n");
                }
                case "deleted" ->
                    resultFile.append("  - ").append(key).append(": ").append(valueOld).append("\n");
                case "added" ->
                    resultFile.append("  + ").append(key).append(": ").append(valueNew).append("\n");
                default -> {

                }
            }
        }
        resultFile.append("}");
        return resultFile.toString();
    }
}
