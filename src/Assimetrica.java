import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Assimetrica {

    public static void executarAssimetrica(String author, String message) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair pair = keyPairGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = encryptCipher.doFinal(message.getBytes());

        String encodedEncryptedMessage = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println(author + " (Encrypted): " + encodedEncryptedMessage);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage = decryptCipher.doFinal(encryptedMessage);
        System.out.println(author + " (Decrypted): " + new String(decryptedMessage));
    }
}
