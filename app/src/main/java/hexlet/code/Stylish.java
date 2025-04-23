package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatter(Map<String, List<Object>> diffMap) {
        List<String> resultFile = new LinkedList<>();

        for (var keys : diffMap.entrySet()) {
            var key = keys.getKey();
            var values = keys.getValue();
            var status = (String) values.get(0);
            var value1 = values.get(1);
            var value2 = values.get(2);

            switch (status) {
                case ("unchanged") :
                    resultFile.add("\n  " + "  " + key + ": " + value1);
                    break;
                case ("changed") :
                    resultFile.add("\n  " + "- " + key + ": " + value1);
                    resultFile.add("\n  " + "+ " + key + ": " + value2);
                    break;
                case ("deleted"):
                    resultFile.add("\n  " + "- " + key + ": " + value1);
                    break;
                case ("added") :
                    resultFile.add("\n  " + "+ " + key + ": " + value2);
                    break;
                default :
            }
        }
        resultFile.addFirst("{");
        resultFile.addLast("\n}");
        return String.join("", resultFile);
    }
}
