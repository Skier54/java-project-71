package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Stylish.ELEMENT_STATUS;
import static hexlet.code.formatters.Stylish.FIRST_VALUE;
import static hexlet.code.formatters.Stylish.SECOND_VALUE;


public class Json {
    public static String formatterJson(Map<String, List<Object>> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> resultFile = new LinkedHashMap<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(ELEMENT_STATUS);
            var valueOld = values.get(FIRST_VALUE);
            var valueNew = values.get(SECOND_VALUE);

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
