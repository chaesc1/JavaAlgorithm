package Softeer.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        String command = inputs[0];

        String key = inputs[1];
        int rotation = Integer.parseInt(inputs[2]);
        String message = inputs[3];
        if (command.equals("encrypt")) {
            System.out.println(encrypt(key, rotation, message));
        } else {
            System.out.println(decrypt(key,rotation,message));
        }
    }

    public static String encrypt(String secret, int rotateNum, String message) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < message.length(); i++) {
            char c = (char) ((message.charAt(i) - 'a' + secret.charAt(i % secret.length()) - 'a') % 26 + 'a');
            sb.append(c);
        }

        String encrypted = sb.toString();
        if (rotateNum < 0) {
            rotateNum = -rotateNum;
            rotateNum %= encrypted.length();
            String front = encrypted.substring(encrypted.length() - rotateNum);
            String back = encrypted.substring(0, encrypted.length() - rotateNum);
            encrypted = front + back;
        } else {
            rotateNum %= encrypted.length();
            String front = encrypted.substring(rotateNum);
            String back = encrypted.substring(0, rotateNum);
            encrypted = front + back;
        }
        return encrypted;
    }

    private static char encryptChar(char original, char key) {
        return (char) ((original - 'a' + key - 'a') % 26 + 'a');
    }
    public static String decrypt(String secret, int rotateNum, String encrypted) {
        if (rotateNum < 0) {
            rotateNum = -rotateNum;
            rotateNum %= encrypted.length();
            String front = encrypted.substring(rotateNum);
            String back = encrypted.substring(0, rotateNum);
            encrypted = front + back;
        } else {
            rotateNum %= encrypted.length();
            String front = encrypted.substring(encrypted.length() - rotateNum);
            String back = encrypted.substring(0, encrypted.length() - rotateNum);
            encrypted = front + back;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < encrypted.length(); i++) {
            char c = (char) ((encrypted.charAt(i) - secret.charAt(i % secret.length()) + 26) % 26 + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}