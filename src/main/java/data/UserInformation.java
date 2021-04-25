package data;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import model.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PhoneUtil;
import utils.ZipCodeUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserInformation {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInformation.class);

    private static final File REGISTER = new File("src/test/resources/register/register.json");

    public void createJsonFileWithUserInformation() {
        final Faker faker = new Faker();
        final Register register = new Register(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.company().buzzword(),
                faker.address().fullAddress(),
                faker.address().city(),
                ZipCodeUtil.getZipCode(),
                faker.address().state(),
                PhoneUtil.getPhoneNumber());

        final Gson gson = new Gson();
        final String toJson = gson.toJson(register);
        OutputStreamWriter streamWriter = null;
        try {
            streamWriter = new OutputStreamWriter(Files.newOutputStream(Paths.get(String.valueOf(REGISTER))), Charset.forName("UTF-8"));
            streamWriter.write(toJson);
            streamWriter.flush();
        } catch (IOException exception) {
            LOGGER.info("The method createJsonFileWithUserInformation is down.", exception);
            new IOException("The method createJsonFileWithUserInformation is down.");
        } finally {
            try {
                if (streamWriter != null) {
                    streamWriter.close();
                }
            } catch (IOException exception) {
                LOGGER.info("The method createJsonFileWithUserInformation is down.", exception);
                new IOException("The method createJsonFileWithUserInformation is down.");
            }
        }
    }
}
