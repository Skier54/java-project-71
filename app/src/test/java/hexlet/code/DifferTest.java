package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
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

    @ParameterizedTest
    @CsvSource({
        "stylish, filepath3.json, filepath4.json, resultStylish.txt",
        "stylish, filepath3.yaml, filepath4.yaml, resultStylish.txt",
        "plain, filepath3.json, filepath4.json, resultPlain.txt",
        "plain, filepath3.yaml, filepath4.yaml, resultPlain.txt",
        "json, filepath3.json, filepath4.json, resultJson.json",
        "json, filepath3.yaml, filepath4.yaml, resultJson.json",
        "json, fileTest4.json, fileTest4.json, filepath1.json",
        "json, fileTest4.yaml, fileTest4.yaml, filepath1.yaml",
        "stylish, filepath3.json, filepath4.yaml, resultStylish.txt",
        "plain, filepath3.json, filepath4.yaml, resultPlain.txt",
        "json, filepath3.json, filepath4.yaml, resultJson.json"
    })
    void testGenerate(String format, String file1, String file2, String expectedFile) throws Exception {
        var expected = readFixture(expectedFile);
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "filepath3.json, filepath4.json, resultStylish.txt",
        "filepath3.yaml, filepath4.yaml, resultStylish.txt",
        "filepath3.json, filepath4.yaml, resultStylish.txt",
    })
    void testGenerateNoFormat(String file1, String file2, String expectedFile) throws Exception {
        var expected = readFixture(expectedFile);
        var actual = Differ.generate(file1, file2);
        assertEquals(expected, actual);
    }
}
