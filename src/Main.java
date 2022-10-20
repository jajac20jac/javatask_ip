import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.zip.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
//набор книжек отсортировать по названию и фамилии автора
//использовать интерфейс comparable compareTOOL
//напісать отдельны
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream("src/input.txt");
        FileWriter writer = new FileWriter("src/output.txt");
        String fileName = "src/input.txt";
        String output = "src/output.txt";
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey AESKey = keygenerator.generateKey();

            Cipher aCipher;
            aCipher = Cipher.getInstance("AES");

            String s = new String(textEncrypted);
            System.out.println(s);

            aCipher.init(Cipher.DECRYPT_MODE, AESKey);
            byte[] textDecrypted = aCipher.doFinal(textEncrypted);

            s = new String(textDecrypted);
            System.out.println(s);
        }
        catch(Exception e) {
            System.out.println("hi");
        }
        try (sc) {
            while(sc.hasNext()) {
//                String line = sc.nextLine();
//                var lst = line.split("^[(]?[-]?([0-9]+)[)]??([(]?([-+/*]([0-9]))?([.,][0-9]+)?[)]?)*$");
//
//                if (lst[1].endsWith("+")) {
//                    System.out.println((int) (Double.parseDouble(lst[0]) + Double.parseDouble(lst[2])));
//                    writer.write(Double.toString(Double.parseDouble(lst[0]) + Double.parseDouble(lst[2])));
//                    writer.write('\n');
//                }
//                else if (lst[1].endsWith("-")) {
//                    System.out.println((int) (Double.parseDouble(lst[0]) - Double.parseDouble(lst[2])));
//                    writer.write(Double.toString(Double.parseDouble(lst[0]) / Double.parseDouble(lst[2])));
//                    writer.write('\n');
//                }
//                else if (lst[1].endsWith("/")) {
//                    System.out.println(Double.toString(Double.parseDouble(lst[0]) / Double.parseDouble(lst[2])));
//                    writer.write(Double.toString(Double.parseDouble(lst[0]) / Double.parseDouble(lst[2])));
//                    writer.write('\n');
//                }
//                else {
//                    System.out.println(Double.toString(Double.parseDouble(lst[0]) * Double.parseDouble(lst[2])));
//                    writer.write(Double.toString(Double.parseDouble(lst[0]) * Double.parseDouble(lst[2])));
//                    writer.write('\n');
//
//                }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException sv) {
            Scanner scs = new Scanner(file);
            while (scs.hasNext()) {
                String s = scs.nextLine();
                KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
                SecretKey AESKey = keygenerator.generateKey();

                Cipher aCipher;
                aCipher = Cipher.getInstance("AES");
                writer.write(line + "\n");

                aCipher.init(Cipher.DECRYPT_MODE, AESKey);
                byte[] textDecrypted = aCipher.doFinal(textEncrypted);

                s = new String(textDecrypted);
                System.out.println(s);
            }
        }
        writer.flush();

        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey AESKey = keygenerator.generateKey();

            Cipher aCipher;
            aCipher = Cipher.getInstance("AES");

            byte[] buffer = new byte[reader.available()];
            reader.read(buffer, 0, buffer.length);

            aCipher.init(Cipher.ENCRYPT_MODE, AESKey);
            byte[] textEncrypted = aCipher.doFinal(buffer);

            String s = new String(textEncrypted);
            System.out.println(s);

            aCipher.init(Cipher.DECRYPT_MODE, AESKey);
            byte[] textDecrypted = aCipher.doFinal(textEncrypted);

            s = new String(textDecrypted);
            System.out.println(s);
        }
        catch(Exception e) {        {
            System.out.println("Exception");
        }

            try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\untitled4\\outputz.zip")); FileInputStream fis= new FileInputStream(output)   )
            {
                ZipEntry entry1 = new ZipEntry(output);
                zout.putNextEntry(entry1);
                zout.closeEntry();
            }
        }
    }
}
