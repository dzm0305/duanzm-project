package com.base.token;

import com.alibaba.druid.util.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

public class TokenTest {

    static {
//        Security.addProvider(new BouncyCastleProvider());
    }

    //密钥
    static String key = "5SlBTN2H5xDSDyuy";
    //偏移量
    static String IVCODE = "5e8y6w45ju8w9jq8";

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {


        long ts = System.currentTimeMillis();
//        long ts = 1636775708922L;
//        String userName = "sys_guolan";
        String userName = "wjq_wgxt";
//        String userName = "zd_zhuoyuan";

        //加密前的token（时间戳-用户名-时间戳）
//        String token = "1615232894840-chqwgxt-1615232894840";
        String token = ts + "-" + userName + "-" + ts;
        //加密密钥，线下交流获取
        String aesKey = "5SlBTN2H5xDSDyuy";
        //偏移量，线下交流获取
        String ivCode = "5e8y6w45ju8w9jq8";

        byte[] encryptBytes = token.getBytes(StandardCharsets.UTF_8);
        byte[] temp = ivCode.getBytes(StandardCharsets.UTF_8);
        IvParameterSpec iv = new IvParameterSpec(temp);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(aesKey.getBytes(), "AES"), iv);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        // 加密后的token
        token = Base64.getEncoder().encodeToString(decryptBytes);

        System.out.println(token);
        System.out.println(URLEncoder.encode(token, "UTF-8"));
        System.out.println(decrypt(token, ts));
//        System.out.println(decrypt("OvkkVoPXFpj7XVExFG10aWMPyA15do3QFLv4p9IXAZUPt7o7BFAdtt+KSdIpD2qP", 1614851655080L));

    }

    //AES解密
    public static String decrypt(String token, long ts) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(IVCODE.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), iv);
            // 采用base64算法进行转码,避免出现中文乱码
            byte[] encryptBytes = Base64.getDecoder().decode(token);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            String decryptString = new String(decryptBytes, StandardCharsets.UTF_8);
            System.out.println(decryptString);
            //默认形式为 ts-userName-ts
            String[] strArray = decryptString.split("-");
            //时间戳判断
            if (!StringUtils.equals(ts + "", strArray[0])) {
                return null;
            } else {
                return strArray[1];
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void xxxx() {
        String content = "{\"handleId\":\"Z0000000000001255202362604126203\",\"eventBigTypeNames\":\"大气\",\"taskContent\":\"test333\",\"psName\":\"污染源测试\",\"psAddr\":\"污染源地址测试\",\"countyName\":\"金牛区\",\"executerName\":\"环科院（走航）\",\"checkContent\":\"123456\",\"hasProblem\":1,\"problemTypeCodes\":null,\"problemType\":\"工地扬尘污染\",\"hasPlanSteps\":0,\"duterId\":null,\"duterName\":null,\"duterPhone\":null,\"isAirCorrelation\":null,\"pointCode\":null,\"pointName\":null,\"pointDistance\":null,\"hasReferPs\":0,\"isDoItNow\":null,\"rectificationContent\":\"\",\"resultImageInfoList\":[{\"imageId\":\"1111\",\"imageName\":\"1111\",\"imageSavePath\":\"http://172.25.80.154:8082/TOW_IMG_UP/2021/02/02/Z0000000000001255202341129289729.jpg\"},{\"imageId\":\"2222\",\"imageName\":\"2222\",\"imageSavePath\":\"http://172.25.80.154:8082/TOW_IMG_UP/2021/02/02/Z0000000000001255202341129289731.jpg\"},{\"imageId\":\"33333\",\"imageName\":\"33333\",\"imageSavePath\":\"http://172.25.80.154:8082/TOW_IMG_UP/2021/02/02/Z0000000000001255202341129289733.jpg\"}]}";
        String resp = null;
        try {
            //url地址
            URL url = new URL("http://xxxx");
            // 建立连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            //提交数据
            try (OutputStream os = connection.getOutputStream()) {
                os.write(content.getBytes(StandardCharsets.UTF_8));
            }

            try (InputStream is = connection.getInputStream()) {
                byte[] bytes = new byte[is.available()];
                int i = is.read(bytes);
                resp = new String(bytes, StandardCharsets.UTF_8);
            }
            connection.disconnect();

        } catch (Exception e) {
            //TODO
        }
//        return resp;
    }
}
