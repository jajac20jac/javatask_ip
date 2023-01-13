import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Archiving {
    public Archiving () {}

    public static void zipFile(String filename, String directoryname) throws java.io.IOException {
        try(ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(directoryname));
            FileInputStream fis = new FileInputStream(filename);)
        {
            ZipEntry entry1 = new ZipEntry(filename.substring(filename.lastIndexOf("\\") + 1));
            zipout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zipout.write(buffer);
            zipout.closeEntry();
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public static void unzipFile(String filename, String directoryname) throws java.io.IOException {
        ZipInputStream zipin = new ZipInputStream(new FileInputStream(filename));
        ZipEntry entry;
        while((entry = zipin.getNextEntry()) != null) {
            FileOutputStream fout = new FileOutputStream(directoryname);
            for (int c = zipin.read(); c != -1; c = zipin.read()) {
                fout.write(c);
            }
            fout.flush();
            zipin.closeEntry();
            fout.close();
        }
    }
}