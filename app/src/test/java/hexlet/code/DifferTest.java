package hexlet.code;

//import static org.junit.Assert.assertEquals;
//import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class DifferTest {

    @Test
    public void testGenerate() throws Exception {

        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        //var filepath1 = readFixture("filepath1.ison");
        //var filepath2 = readFixture("filepath2.ison");
        var actual = Differ.generate("filepath1.ison", "filepath2.ison");
        assertEquals(expected, actual);
    }
}
