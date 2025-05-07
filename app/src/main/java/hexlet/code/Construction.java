package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class Construction {
    public static Map<String, List<Object>> building(Map<String, Object> parsDataOne, Map<String, Object> parsDataTwo) {
        Map<String, Object> parsedDataResult = new TreeMap<>(parsDataOne);

        parsedDataResult.putAll(parsDataTwo);

        Map<String, List<Object>> diffResult = new LinkedHashMap<>();

        for (var key : parsedDataResult.keySet()) {
            var value1 = parsDataOne.get(key);
            var value2 = parsDataTwo.get(key);

            if (parsDataOne.containsKey(key) && parsDataTwo.containsKey(key)
                    && Objects.equals(value1, value2)) {
                diffResult.put(key, Arrays.asList("unchanged", value1, value2));
            } else if (parsDataOne.containsKey(key) && parsDataTwo.containsKey(key)
                    && !Objects.equals(value1, value2)) {
                diffResult.put(key, Arrays.asList("changed", value1, value2));
            } else if (parsDataOne.containsKey(key) && !parsDataTwo.containsKey(key)) {
                diffResult.put(key, Arrays.asList("deleted", value1, null));
            } else if (!parsDataOne.containsKey(key) && parsDataTwo.containsKey(key)) {
                diffResult.put(key, Arrays.asList("added", null, value2));
            }
        }
        return diffResult;
    }
}
