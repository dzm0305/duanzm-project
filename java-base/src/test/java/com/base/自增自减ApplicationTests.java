package com.base;

import com.alibaba.druid.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
import java.util.Base64;

@SpringBootTest
class 自增自减ApplicationTests {

    @Test
    void run() {
        int a = 0;
        int b = a++;
        System.out.println("a:" + a); // 1
        System.out.println("b:" + b); // 0
        int c = 0;
        int d = ++c;
        System.out.println("c:" + c); // 1
        System.out.println("d:" + d); // 1
    }
}
