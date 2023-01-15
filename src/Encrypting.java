

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Encrypting {
    static final int len = 1024;
    static private byte[] key_value = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+".getBytes();;
    public Encrypting() {};

    public Encrypting( String key) {
        key_value = key.getBytes();
    }

    public static void encryptFile(String oldFile, String newFile) throws Exception {
        encrypt(oldFile, newFile);
        return;
    }

    public static void decryptFile(String oldFile, String newFile) throws Exception {
        encrypt(oldFile, newFile);
    }
    
    private static void encrypt(String oldFile, String newFile) throws IOException {
        FileInputStream in = new FileInputStream(oldFile);
        File file = new File(newFile);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c, pos, keylen;
        pos = 0;
        keylen = key_value.length;
        byte buffer[] = new byte[len];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                buffer[i] ^= key_value[pos];
                out.write(buffer[i]);
                pos++;
                if (pos == keylen)
                    pos = 0;
            }
        }
        in.close();
        out.close();
    }


};