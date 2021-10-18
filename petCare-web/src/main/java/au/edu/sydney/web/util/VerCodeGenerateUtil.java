package au.edu.sydney.web.util;

import java.security.SecureRandom;
import java.util.Random;


/**
 * @author Chris
 * @date 2021-09-14 21:08
 */
public class VerCodeGenerateUtil {
    private static final String SYMBOLS = "0123456789";
    private static final Random RANDOM = new SecureRandom();

    /**
     * Generate 6-digit random numbers
     * @return Return 6-digit verification code
     */
    public static String generateVerCode() {
        char[] nonceChars = new char[6];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
