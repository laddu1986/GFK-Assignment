package com.utils.extra_utils;

import java.util.Random;

public class ApiTestUtil {
    /**
     * Method to genarate a random number
     * "Generate a random number"
     *
     * @return int
     *
     */
    public static int generateRandomNumber() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(999);
        return randomInt;

    }
}