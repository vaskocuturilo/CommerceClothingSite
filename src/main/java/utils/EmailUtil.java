package utils;

import java.util.Date;

public class EmailUtil {

    public static String createEmailForNewUser() {
        final String todayData = String.valueOf(new Date().getTime());

        return "newsletter_email_" + todayData + "@qa.team";
    }
}
