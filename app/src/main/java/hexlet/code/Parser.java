package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    private static Path getFixturePath(String fileName) {
        Path path = Paths.get(fileName);

        if (!path.isAbsolute()) {
            return Paths.get("src", "test", "resources", "fixtures", fileName)
                    .toAbsolutePath().normalize();
        } else {
            return path.normalize();
        }
    }

    static String readFixture(String filename) throws IOException {
        var path = getFixturePath(filename);

        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + path);
        }
        return Files.readString(path).trim();
    }

    public static Map<String, Object> getData(String filename) throws Exception {
        String extension = filename.substring(filename.lastIndexOf('.') + 1);
        ObjectMapper objectMapper = switch (extension) {
            case "json" -> new ObjectMapper();
            case "yaml", "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new UnsupportedOperationException("Unsupported input format: " + extension);
        };
        String json = readFixture(filename);
        return objectMapper.readValue(json, new TypeReference<>() { });
    }
}
