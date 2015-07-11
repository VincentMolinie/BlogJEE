package tools;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by F on 11/07/2015.
 */
public class PasswordHelper {
    public String generate(String input) throws HashGenerateException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashInput = messageDigest.digest(input.getBytes("UTF-8"));

            return Hex.encodeHexString(hashInput);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new HashGenerateException("Hash could not be generated!", e);        }
    }
}
