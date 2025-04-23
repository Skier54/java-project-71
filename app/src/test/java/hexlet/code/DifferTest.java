package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DifferTest {

    @Test
    void testGenerateOne() throws Exception {
        var expected = """
                {
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        var actual = Differ.generate("fileTest1.json", "fileTest2.json");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateTwo() throws Exception {
        var expected = """
                {
                  - chars1: [a, b, c]
                  - chars2: [d, e, f]
                  - checked: false
                  - default: null
                  - id: 45
                  - key1: value1
                  - numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  - numbers3: [3, 4, 5]
                  - setting1: Some value
                  - setting2: 200
                  - setting3: true
                }""";

        var actual = Differ.generate("fileTest3.json", "fileTest4.json");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateThree() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.json", "fileTest4.json");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFour() throws Exception {
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        var actual = Differ.generate("filepath3.yaml", "filepath4.yaml");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateSix() throws Exception {
        var expected = """
                {
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        var actual = Differ.generate("fileTest1.yaml", "fileTest2.yaml");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateSeven() throws Exception {
        var expected = """
                {
                  - chars1: [a, b, c]
                  - chars2: [d, e, f]
                  - checked: false
                  - default: null
                  - id: 45
                  - key1: value1
                  - numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  - numbers3: [3, 4, 5]
                  - setting1: Some value
                  - setting2: 200
                  - setting3: true
                }""";

        var actual = Differ.generate("fileTest3.yaml", "fileTest4.yaml");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateEight() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.yaml", "fileTest4.yaml");
        assertEquals(expected, actual);
    }
}
