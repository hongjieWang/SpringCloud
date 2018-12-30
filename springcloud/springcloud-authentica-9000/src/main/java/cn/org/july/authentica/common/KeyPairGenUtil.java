package cn.org.july.authentica.common;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObject;

import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成密钥对
 *
 * @author july_whj
 */
public class KeyPairGenUtil {
    /**
     *  指定加密算法为RSA 
     */
    public static final String ALGORITHM = "RSA";
    /**
     *  密钥长度，用来初始化 
     */
    public static final int KEYSIZE = 2048;
    /**
     *  指定公钥存放文件 
     */
    private static String PUBLIC_KEY_FILE = "PublicKey";
    /**
     *  指定私钥存放文件 
     */
    private static String PRIVATE_KEY_FILE = "PrivateKey";

    /**
     * 生成没有加过密的公私钥
     */
    public static Map<String, Object> createKey(String algorithm, int keySize) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(algorithm);
        keyPairGen.initialize(keySize);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put("publicKey", publicKey);
        keyMap.put("privateKey", privateKey);
        return keyMap;
    }





    /**
     * 将私钥字符串生成文件
     * @param privateKeyStr
     * @param filePath
     */
    public static void createPrivateKeyFile(String privateKeyStr,String filePath){
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.print(privateKeyStr);
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从pkcs#1私钥文件 得到RSA公私钥对象
     * @param filePath RSA私钥文件路径 (PEM文件已加密)
     * @param filePasswd 私钥加密秘钥
     * @return 返回RSA公私钥对象
     */
    public static Map<String,Object> getRSAPrivateKeyEncrypted(String filePath,final String filePasswd) {
        FileInputStream fis = null;
        ByteArrayInputStream bais = null;
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            fis = new FileInputStream(new File(filePath));
            byte[] fileContent = new byte[fis.available()];
            fis.read(fileContent);

            Security.addProvider(new BouncyCastleProvider());
            bais = new ByteArrayInputStream(fileContent);
            PEMParser reader = new PEMParser(new InputStreamReader(bais));
            //判断文件在加密情况下，用户是否输入了密码
            reader.mark(1);
            //System.out.println(reader.markSupported());
            reader.readLine();
            String isEncrytedStr = reader.readLine();
            if(isEncrytedStr.endsWith("ENCRYPTED") && (filePasswd == null || filePasswd.equals(""))){
                map.put("noPasswd", "私钥文件已加密，需私钥密码");
                return map;
            }
            if(isEncrytedStr.endsWith("ENCRYPTED")){ //文件类型
                map.put("type", "ENCRYPTED");
            }else{
                map.put("type", "NOENCRYPTED");
            }
            reader.reset();

            KeyPair keyPair = (KeyPair) reader.readObject();
            reader.close();

            //解密后获取公钥和私钥
            PublicKey pubk = keyPair.getPublic();//pkcs#8格式公钥
            PrivateKey prik = keyPair.getPrivate();//pkcs#8格式私钥  //JCERSAPrivateCrtKey
            System.out.println(prik.getFormat());

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            KeySpec keySpec = new X509EncodedKeySpec(pubk.getEncoded());
            KeySpec keySpec2 = new PKCS8EncodedKeySpec(prik.getEncoded());
            RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
            RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec2);

            System.out.println(Base64.encode(privateKey.getEncoded()));//从输出结果可以知道是PKCS#8格式的

            map.put("publicKey", publicKey);
            map.put("privateKey", privateKey);

            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            return map;
        }finally {
            try {
                if (bais != null) {
                    bais.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    public static void main(String[] args) {
        try {
            //生成加密的公私钥
            Map<String, Object> encryKeyStrMap = KeyPairGenUtil.createKey(KeyPairGenUtil.ALGORITHM,
                    KeyPairGenUtil.KEYSIZE);
            System.out.println(encryKeyStrMap.get("publicKey"));
            System.out.println("---------------");
            System.out.println(encryKeyStrMap.get("privateKey"));

            //私钥生成文件
            //String filePath = "C:\\Users\\NP0612\\Desktop\\test_priv.pem";
            //	LukeRsa.createPrivateKeyFile(encryKeyStrMap.get("privateKeyStr").toString(), filePath);

            //从私钥文件获取公私钥对象
            //LukeRsa.getRSAPrivateKeyEncrypted(filePath, filePasswd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
