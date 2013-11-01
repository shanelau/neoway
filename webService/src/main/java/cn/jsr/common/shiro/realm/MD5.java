package cn.jsr.common.shiro.realm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }


    public static String MD5Encode(String message) {
        String messageEncode = null;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(message.getBytes());

            messageEncode = bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return messageEncode;
    }

    public static void main(String args[]) {
        System.out.println(MD5Encode("123"));
    }


}