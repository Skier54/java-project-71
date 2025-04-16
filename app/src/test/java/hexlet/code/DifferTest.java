package hexlet.code;

//import static org.junit.Assert.assertEquals;
//import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    public void testGenerateOne() throws Exception {
        var expected = """
                {
                  - follow: 50
                  + follow: false
                  - host: hexlet.io
                  + host: true
                }""";

        var actual = Differ.generate("fileTest1.json", "fileTest2.json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateTwo() throws Exception {
        var expected = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";

        var actual = Differ.generate("fileTest3.json", "fileTest4.json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateThree() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.json", "fileTest4.json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateFour() throws Exception {
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        var actual = Differ.generate("filepath1.yaml", "filepath2.yaml");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateSix() throws Exception {
        var expected = """
                {
                  - follow: 50
                  + follow: false
                  - host: hexlet.io
                  + host: true
                }""";

        var actual = Differ.generate("fileTest1.yaml", "fileTest2.yaml");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateSeven() throws Exception {
        var expected = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";

        var actual = Differ.generate("fileTest3.yaml", "fileTest4.yaml");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateEight() throws Exception {
        var expected = """
                {
                }""";

        var actual = Differ.generate("fileTest4.yaml", "fileTest4.yaml");
        assertEquals(expected, actual);
    }
}
