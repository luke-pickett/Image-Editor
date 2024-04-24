package com.mygdx.image_editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

import java.nio.ByteBuffer;
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

    public static byte[] intToSignedBytes(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static void testIntToSignedBytes() {
        byte[] testResults = intToSignedBytes(543152314);
        int[] expectedResults = {32, 95, -40, -70};
        for(int i = 0; i < testResults.length; i++) {
            if((int) testResults[i] != expectedResults[i])
                System.out.println("TEST FAILED! INDEX " + i + " IS "
                        + testResults[i] + " EXPECTED: " + expectedResults[i]);
        }
    }
    
    public static Pixmap scalePixmap(Pixmap source, Vector2 desiredSize) {
        Pixmap target = new Pixmap((int) desiredSize.x, (int) desiredSize.y, Pixmap.Format.RGBA8888);
        for (int targetX = 0; targetX < target.getWidth(); targetX++) {
            for (int targetY = 0; targetY < target.getHeight(); targetY++) {
                int srcX = (int) Math.round((float) targetX / (float) target.getWidth() * (float) source.getWidth());
                int srcY = (int) Math.round((float) targetY / (float) target.getHeight() * (float) source.getHeight());
                srcX = Math.min(srcX, source.getWidth() - 1);
                srcY = Math.min(srcY, source.getHeight() - 1);
                Color color = new Color(source.getPixel(srcX, srcY));
                target.setColor(color);
                target.drawPixel(targetX, targetY);
            }
        }
        return target;
    }
}
