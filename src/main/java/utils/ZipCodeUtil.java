package utils;

import java.util.Random;

public class ZipCodeUtil {

    public static String getZipCode() {
        StringBuilder zipCode = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Random generator = new Random();
            zipCode.append(generator.nextInt(4));
        }
        return "0" + zipCode.toString();
    }
}
