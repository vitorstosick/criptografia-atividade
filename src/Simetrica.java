import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Simetrica {

    public static void executarSimetrica(String author, String message) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedMessage = encryptCipher.doFinal(message.getBytes());

//        String encodedEncryptedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println(author + " (Encrypted): " + new String(encryptedMessage));

        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedMessage = decryptCipher.doFinal(encryptedMessage);

        System.out.println(author + " (Decrypted): " + new String(decryptedMessage));
    }

}
