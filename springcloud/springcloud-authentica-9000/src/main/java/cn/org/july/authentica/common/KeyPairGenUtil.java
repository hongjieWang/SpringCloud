package cn.org.july.authentica.common;

/**
 * 生成密钥对
 *
 * @author july_whj
 */
public class KeyPairGenUtil {
    /**
     *  指定加密算法为RSA 
     */
    private static final String ALGORITHM = "RSA";
    /**
     *  密钥长度，用来初始化 
     */
    private static final int KEYSIZE = 2048;
    /**
     *  指定公钥存放文件 
     */
    private static String PUBLIC_KEY_FILE = "PublicKey";
    /**
     *  指定私钥存放文件 
     */
    private static String PRIVATE_KEY_FILE = "PrivateKey";


}
