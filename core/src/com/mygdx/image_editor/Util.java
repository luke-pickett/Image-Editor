package com.mygdx.image_editor;

import java.util.Arrays;

public class Util {
    public static int bytesToInt(byte[] bytes) {
        int result = 0;
        int[] intArray = unsignBytes(bytes);
        for(int i = 0; i < intArray.length; i++) {
            result += intArray[i] << (8*i);
        }
        return result;
    }

    public static int[] unsignBytes(byte[] bytes) {
        int[] ints = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            int current = bytes[i];
            if (current >= 0) {
                ints[i] = current;
            }
            else {
                int distance = current + 129;
                ints[i] = distance + 127;
            }
        }
        return ints;
    }
}
