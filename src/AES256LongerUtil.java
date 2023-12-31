import cn.com.nebula.core.common.PropertiesUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName AES256LongerUtil
 * @Description 当被加密字符过长时使用该类进行加密
 * @Author lx
 * @Date 2019-02-22 10:30
 */
public class AES256LongerUtil {
    // 加密
//    public static String Encrypt(String sSrc, String sKey) throws Exception {
//        if (sKey == null) {
//            System.out.print("Key为空null");
//            return null;
//        }
//        // 判断Key是否为16位
//        if (sKey.length() != 16) {
//            System.out.print("Key长度不是16位");
//            return null;
//        }
//        byte[] raw = sKey.getBytes();
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
//        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
//
//        return Base64Util.encode(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
//    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64Util.decodeToBytes(sSrc);// Base64Decoder.decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                // System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            // System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String signature  ="77+9IDZSVe+/vVnvv73msJQEeiTol4jlqbjugYstfuiRtyo554ud5a6t6Im/77+9Ju+/vQwVWWIM5ruiMe6IkHHul5Yl5om056SM6aqDce+/veeKkQ==";
        String encryptParameter = AES256LongerUtil.Decrypt(signature, "userInfoMobileAE");
        System.out.println("EncryptParameter:" + signature + "解密后：" + encryptParameter);
    }
}
