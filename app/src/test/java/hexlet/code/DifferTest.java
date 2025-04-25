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

        var actual = Differ.generate("fileTest1.json", "fileTest2.json", "stylish");
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

        var actual = Differ.generate("fileTest3.json", "fileTest4.json", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateThree() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.json", "fileTest4.json", "stylish");
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

        var actual = Differ.generate("filepath3.yaml", "filepath4.yaml", "stylish");
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

        var actual = Differ.generate("fileTest1.yaml", "fileTest2.yaml", "stylish");
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

        var actual = Differ.generate("fileTest3.yaml", "fileTest4.yaml", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateEight() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.yaml", "fileTest4.yaml", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testGeneratePlainOne() throws Exception {
        var expected = """
                
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        var actual = Differ.generate("filepath3.yaml", "filepath4.yaml", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testGeneratePlainTwo() throws Exception {
        var expected = """
                
                Property 'chars1' was removed
                Property 'chars2' was removed
                Property 'checked' was removed
                Property 'default' was removed
                Property 'id' was removed
                Property 'key1' was removed
                Property 'numbers1' was removed
                Property 'numbers2' was removed
                Property 'numbers3' was removed
                Property 'setting1' was removed
                Property 'setting2' was removed
                Property 'setting3' was removed""";

        var actual = Differ.generate("fileTest3.yaml", "fileTest4.yaml", "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testGeneratePlainThree() throws Exception {
        var expected = """
                """;

        var actual = Differ.generate("fileTest4.yaml", "fileTest4.yaml", "plain");
        assertEquals(expected, actual);
    }
}
