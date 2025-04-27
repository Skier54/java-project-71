package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatter(Map<String, List<Object>> diffMap) {
        List<String> resultFile = new LinkedList<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(0);
            var valueOld = values.get(1);
            var valueNew = values.get(2);

            switch (status) {
                case "unchanged" ->
                    resultFile.add("\n  " + "  " + key + ": " + valueOld);
                case "changed" -> {
                    resultFile.add("\n  " + "- " + key + ": " + valueOld);
                    resultFile.add("\n  " + "+ " + key + ": " + valueNew);
                }
                case "deleted" ->
                    resultFile.add("\n  " + "- " + key + ": " + valueOld);
                case "added" ->
                    resultFile.add("\n  " + "+ " + key + ": " + valueNew);
                default -> {

                }
            }
        }
        resultFile.addFirst("{");
        resultFile.addLast("\n}");
        return String.join("", resultFile);
    }
}
