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
                  + follow: false
                  - host: hexlet.io
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
}
