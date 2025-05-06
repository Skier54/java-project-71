package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class Construction {
    public static Map<String, List<Object>> building(Map<String, Object> fileMapOne, Map<String, Object> fileMapTwo) {
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
        return diffMap;
    }
}
