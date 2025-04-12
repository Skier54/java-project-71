package hexlet.code;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static hexlet.code.FileProcessor.getData;

public class Differ {

    static String generate(String fileNameOne, String fileNameTwo) throws Exception {
        Map<String, Object> fileMapOne = getData(fileNameOne);
        Map<String, Object> fileMapTwo = getData(fileNameTwo);
        Map<String, Object> fileMapOneTwo = new TreeMap<>(fileMapOne);
        List<String> resultFile = new LinkedList<>();

        fileMapOneTwo.putAll(fileMapTwo);

        for (var key : fileMapOneTwo.keySet()) {
            if (fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)
                    && Objects.equals(fileMapOne.get(key), fileMapTwo.get(key))) {
                resultFile.add("\n  " + "  " + key + ": " + fileMapOne.get(key));
            } else if (fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)
                    && !Objects.equals(fileMapOne.get(key), fileMapTwo.get(key))) {
                resultFile.add("\n  " + "- " + key + ": " + fileMapOne.get(key));
                resultFile.add("\n  " + "+ " + key + ": " + fileMapTwo.get(key));
            } else if (fileMapOne.containsKey(key) && !fileMapTwo.containsKey(key)) {
                resultFile.add("\n  " + "- " + key + ": " + fileMapOne.get(key));
            } else if (!fileMapOne.containsKey(key) && fileMapTwo.containsKey(key)) {
                resultFile.add("\n  " + "+ " + key + ": " + fileMapTwo.get(key) + "\n");
            }
        }
        resultFile.addFirst("{");
        resultFile.addLast("}");
        return String.join("", resultFile);
    }
}
