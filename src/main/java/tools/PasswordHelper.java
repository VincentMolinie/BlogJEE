package tools;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by F on 11/07/2015.
 */
public class PasswordHelper {
    public static String generate(String input) throws HashGenerateException {
        String hash = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashInput = messageDigest.digest(input.getBytes("UTF-8"));

            hash = Hex.encodeHexString(hashInput);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new HashGenerateException("Hash could not be generated!", e);
        }
        return hash;
    }

    public static Boolean compareHash(String input, String hashedInput) throws HashGenerateException {
        String hInput = generate(input);

        return (hInput != null && hInput.equals(hashedInput));
    }
}
