package helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;

public class Utility {
    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }
    public static String getRandomEmail(){
        String allowedChar = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-_.";
        String email = "";
        String tmp = RandomStringUtils.randomAlphanumeric(10); // email panjang 10 character
        email = tmp + "@test.com";
        return email;
    }
}
