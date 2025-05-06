package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Stylish.ELEMENT_STATUS;
import static hexlet.code.formatters.Stylish.FIRST_VALUE;
import static hexlet.code.formatters.Stylish.SECOND_VALUE;


public class Json {
    public static String formatterJson(Map<String, List<Object>> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Map<String, Object>> resultFile = new LinkedHashMap<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(ELEMENT_STATUS);
            var valueOld = values.get(FIRST_VALUE);
            var valueNew = values.get(SECOND_VALUE);

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("status", status);

            switch (status) {
                case "unchanged" ->
                    result.put("value", valueOld);
                case "changed" -> {
                    result.put("valueOld", valueOld);
                    result.put("valueNew", valueNew);
                }
                case "deleted" ->
                    result.put("value", valueOld);
                case "added" ->
                    result.put("value", valueNew);
                default -> {

                }
            }
            resultFile.put(key, result);
        }
        return objectMapper.writeValueAsString(resultFile);
    }
}
