package com.base.mp;

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
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class MpApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("------------------");
        System.out.println(System.currentTimeMillis());
        System.out.println("------------------");
        Date now = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowStr = sdf.format(now); //得到今天凌晨时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date tomorrow1 = calendar.getTime();
        String tomorrowStr1 = sdf.format(tomorrow1);
        String tomorrowWeek1 = getWeek(tomorrow1);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date tomorrow2 = calendar.getTime();
        String tomorrowStr2 = sdf.format(tomorrow2);
        String tomorrowWeek2 = getWeek(tomorrow2);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date tomorrow3 = calendar.getTime();
        String tomorrowStr3 = sdf.format(tomorrow3);
        String tomorrowWeek3 = getWeek(tomorrow3);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date tomorrow4 = calendar.getTime();
        String tomorrowStr4 = sdf.format(tomorrow4);
        String tomorrowWeek4 = getWeek(tomorrow4);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        Date tomorrow5 = calendar.getTime();
        String tomorrowStr5 = sdf.format(tomorrow5);
        String tomorrowWeek5 = getWeek(tomorrow5);
        System.out.println("------------------------" + tomorrowStr1.substring(5, 10).replace("-", "/") );
        System.out.println("------------------------" + tomorrowWeek1 + tomorrowWeek2 + tomorrowWeek3 + tomorrowWeek4+ tomorrowWeek5);
    }

    public static String getWeek(Date date){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }
}
