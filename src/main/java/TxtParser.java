
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtParser {
    private static String inputFileName;
    private static String outputFileName;
    public TxtParser(String inputName, String outputName) {
        inputFileName = inputName;
        outputFileName = outputName;
    }
    public static String ReadFromFile() throws IOException {
        FileReader fr = new FileReader(inputFileName);
        BufferedReader reader = new BufferedReader(fr);
        return reader.readLine();
    }

    public static void WriteToFile() throws IOException {
        FileWriter fw = new FileWriter(outputFileName);
        ArifParser arifParser = new ArifParser(ReadFromFile());
        fw.write(Double.toString(arifParser.ArifParserToAnswer()));
        fw.flush();
    }

}
