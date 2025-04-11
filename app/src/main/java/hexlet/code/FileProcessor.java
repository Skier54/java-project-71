package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileProcessor {
    static ObjectMapper objectMapper = new ObjectMapper();

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    private static String readFixture(String filename) throws Exception {
        var path = getFixturePath(filename);
        return Files.readString(path).trim();
    }

    public static Map<String, Object> getData(String filename) throws Exception {
        String json = readFixture(filename);
        return objectMapper.readValue(json, new TypeReference<>() { });
    }
}
