package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file")
    private File filepath1;

    @Parameters(index = "0", description = "path to second file")
    private File filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "format";

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
