package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String json, String extension) throws IOException {
        ObjectMapper objectMapper = receivingObjectMapper(extension);
        return objectMapper.readValue(json, new TypeReference<>() { });
    }

    static ObjectMapper receivingObjectMapper(String extension) {
        return switch (extension) {
            case "json" -> new ObjectMapper();
            case "yaml", "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new UnsupportedOperationException("Unsupported input format: " + extension);
        };
    }
}
