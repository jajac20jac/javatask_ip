
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String txtInput = "src/main/java/inputOutput/input.txt";
        String txtOutput = "src/main/java/inputOutput/output.txt";
        String xmlInput = "src/main/java/inputOutput/input.xml";
        String xmlOutput = "src/main/java/inputOutput/output.xml";
        String cipheredOutput = "src/main/java/inputOutput/cipheredOutput.txt";
        String decipheredOutput = "decipheredOutput.txt";
        String zipOutput = "src/main/java/inputOutput/outputzip.zip";
        Scanner in = new Scanner(System.in);
        String temp;
            TxtParser txtp = new TxtParser(txtInput, txtOutput);
            txtp.WriteToFile();

        String wayName = "src/main/java/inputOutput/outputz.zip";
        Archiving arch = new Archiving();
        arch.zipFile(txtInput, wayName);
        arch.unzipFile(wayName, zipOutput);



        Encrypting encr = new Encrypting();
        encr.encryptFile(txtOutput, cipheredOutput);
        encr.decryptFile(cipheredOutput, decipheredOutput);

        XmlParser xl = new XmlParser(xmlInput, xmlOutput);
        xl.WriteXML();
//
}}


