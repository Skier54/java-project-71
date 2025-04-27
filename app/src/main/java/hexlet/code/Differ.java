package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.List;

import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String fileNameOne, String fileNameTwo, String formatName) throws Exception {
        Map<String, Object> fileMapOne = getData(fileNameOne);
        Map<String, Object> fileMapTwo = getData(fileNameTwo);
        Map<String, Object> fileMapOneTwo = new TreeMap<>(fileMapOne);

        fileMapOneTwo.putAll(fileMapTwo);

        Map<String, List<Object>> diffMap = new LinkedHashMap<>();

        for (var key : fileMapOneTwo.keySet()) {
            var value1 = fileMapOne.get(key);
            var value2 = fileMapTwo.get(key);

            if (fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)
                    && Objects.equals(value1, value2)) {
                diffMap.put(key, Arrays.asList("unchanged", value1, value2));
            } else if (fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)
                    && !Objects.equals(value1, value2)) {
                diffMap.put(key, Arrays.asList("changed", value1, value2));
            } else if (fileMapOne.containsKey(key) && !fileMapTwo.containsKey(key)) {
                diffMap.put(key, Arrays.asList("deleted", value1, null));
            } else if (!fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)) {
                diffMap.put(key, Arrays.asList("added", null, value2));
            }
        }
        return Formatter.formatSelection(diffMap, formatName);
    }
}

