package utils;

import java.util.Random;

public class PhoneUtil {
    public static String getPhoneNumber() {
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            Random generator = new Random();
            phone.append(generator.nextInt(8));
        }
        return "9" + phone.toString();
    }
}
