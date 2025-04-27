package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {
    public static String formatter(Map<String, List<Object>> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> resultFile = new LinkedHashMap<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(0);
            var valueOld = values.get(1);
            var valueNew = values.get(2);

            switch (status) {
                case "unchanged" ->
                    resultFile.put(key, valueOld);
                case "changed" -> {
                    Map<String, Object> changedValue = new LinkedHashMap<>();
                    changedValue.put("-", valueOld);
                    changedValue.put("+", valueNew);
                    resultFile.put(key, changedValue);
                }
                case "deleted" ->
                    resultFile.put("- " + key, valueOld);
                case "added" ->
                    resultFile.put("+ " + key, valueNew);
                default -> {

                }
            }
        }
        return objectMapper.writeValueAsString(resultFile);
    }
}
