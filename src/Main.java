import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String txtInput = "src/inputOutput/input.txt";
        String txtOutput = "src/inputOutput/output.txt";
        String xmlInput = "src/inputOutput/input.xml";
        String xmlOutput = "src/inputOutput/output.xml";
        String cipheredOutput = "src/inputOutput/cipheredOutput.txt";
        String zipOutput = "src/inputOutput/outputz.zip";
        Scanner in = new Scanner(System.in);
        String temp;
        System.out.println("Введите \"1\" если хотите прочитать txt файл\n" +
                "Введите \"2\" если хотите прочитать xml файл\n" +
                "Введите \"3\" если хотите прочитать json файл\n" +
                "Введите \"4\" если хотите заархивировать файл исопльзуя Zip\n" +
                "Введите \"5\" если хотите заархивировать файл используя Rar\n" +
                "Введите \"6\" если хотите зашифровать файл с помощью AES\n" +
                "Введите \"7\" если хотите расшифровать файл с помощью AES\n");
        int a = in.nextInt();
        if (a == 1){
            TxtParser ptx = new TxtParser(txtInput, txtOutput);
            temp = ptx.ReadFromFile();
        }
        if (a == 2){

        }
        if (a == 3){

        }
        if (a == 4){
            System.out.println("Введите ");
        }
        if (a == 5){

        }
//
}}


