package utils;

import java.util.Random;

import static utils.EmailClient.SERVER_DOMAIN;
import static utils.EmailClient.SERVER_ID;

public class SharedFunctions {
    /**
     * Get random string in lowercase
     *
     * @param length wished length for generated string
     */

    public static String getRandomStringWithLength(int length) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        if(length < 0) {
            throw new IllegalArgumentException("String length should be more than zero");
        }
        StringBuilder sbuilder = new StringBuilder();
        for (int i=0; i< length; i++){
            sbuilder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sbuilder.toString();
    }

    public static String getNewEmailAddress(){
        String randomName = getRandomStringWithLength(8);
        return randomName + "@" + SERVER_ID + SERVER_DOMAIN;
    }
}
