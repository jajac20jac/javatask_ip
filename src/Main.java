import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream("src/input.txt");
        FileWriter writer = new FileWriter("src/output.txt");
        String fileName = "src/input.txt";
        String output = "src/output.txt";

        Scanner sc = new Scanner(fileName);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите \"1\" если хотите прочитать txt файл\n" +
                "Введите \"2\" если хотите прочитать xml файл\n" +
                "Введите \"3\" если хотите прочитать json файл\n" +
                "Введите \"4\" если хотите заархивировать файл исопльзуя Zip\n" +
                "Введите \"5\" если хотите заархивировать файл используя Rar\n" +
                "Введите \"6\" если хотите зашифровать файл с помощью AES\n" +
                "Введите \"7\" если хотите расшифровать файл с помощью AES\n");
        int a = in.nextInt();

//
}}


