package cn.org.july.authentica.common;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Map;

public class SignTest {

    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static final String ENCODE_ALGORITHM = "SHA-256";

    public static final String PLAIN_TEXT = "test string";

    public static void main(String[] args) throws Exception {
        Map<String, Object> keyMap = KeyPairGenUtil.createKey(KeyPairGenUtil.ALGORITHM,
                KeyPairGenUtil.KEYSIZE);
        PublicKey publicKey = (PublicKey) keyMap.get("publicKey");
        PrivateKey privateKey = (PrivateKey) keyMap.get("privateKey");
        byte[] signBytes = sign(privateKey, PLAIN_TEXT);
        System.out.println(verifySign(publicKey, PLAIN_TEXT, signBytes));
    }

    /**
     * 签名
     * @param privateKey  私钥
     * @param plainText 明文
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, String plainText) {
        MessageDigest messageDigest;
        byte[] signed = null;
        try {
            messageDigest = MessageDigest.getInstance(ENCODE_ALGORITHM);
            messageDigest.update(plainText.getBytes());
            byte[] outputDigest_sign = messageDigest.digest();
            System.out.println("SHA-256编码后-----》"
                    + bytesToHexString(outputDigest_sign));
            Signature Sign = Signature.getInstance(SIGNATURE_ALGORITHM);
            Sign.initSign(privateKey);
            Sign.update(outputDigest_sign);
            signed = Sign.sign();
            System.out.println("SHA256withRSA签名后-----》"
                    + bytesToHexString(signed));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return signed;
    }

    /**
     * 验签
     * @param publicKey 公钥
     * @param plain_text 明文
     * @param signed 签名
     */
    public static boolean verifySign(PublicKey publicKey, String plain_text, byte[] signed) {
        MessageDigest messageDigest;
        boolean SignedSuccess=false;
        try {
            messageDigest = MessageDigest.getInstance(ENCODE_ALGORITHM);
            messageDigest.update(plain_text.getBytes());
            byte[] outputDigest_verify = messageDigest.digest();
            System.out.println("SHA-256加密后-----》" +bytesToHexString(outputDigest_verify));
            Signature verifySign = Signature.getInstance(SIGNATURE_ALGORITHM);
            verifySign.initVerify(publicKey);
            verifySign.update(outputDigest_verify);
            SignedSuccess = verifySign.verify(signed);
            System.out.println("验证成功？---" + SignedSuccess);

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return SignedSuccess;
    }


    /**
     * bytes[]换成16进制字符串
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}

