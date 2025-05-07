package hexlet.code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static hexlet.code.Parser.getData;

public class Differ {
    private static final String PATH_TO_FILE = "src/test/resources/fixtures";

    private static Path getFixturePath(String fileName) {
        Path path = Paths.get(fileName);

        if (!path.isAbsolute()) {
            return Paths.get(PATH_TO_FILE, fileName)
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

    static String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf('.') + 1);
    }

    public static String generate(String fileNameOne, String fileNameTwo, String formatName) throws Exception {
        String extensionOne = getFileExtension(fileNameOne);
        String extensionTwo = getFileExtension(fileNameTwo);

        String dataFileOne = readFixture(fileNameOne);
        String dataFileTwo = readFixture(fileNameTwo);

        Map<String, Object> parsedDataOne = getData(dataFileOne, extensionOne);
        Map<String, Object> parsedDataTwo = getData(dataFileTwo, extensionTwo);

        var diffResult = Construction.building(parsedDataOne, parsedDataTwo);

        return Formatter.formatSelection(diffResult, formatName);
    }

    public static String generate(String fileNameOne, String fileNameTwo) throws Exception {
        return generate(fileNameOne, fileNameTwo, "stylish");
    }
}

