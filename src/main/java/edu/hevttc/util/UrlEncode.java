package edu.hevttc.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Pc.dragon
 * @ClassName UrlEncode
 * @description: url中特殊字符的编码与解码
 * @date 2023年02月02日
 * @version: 1.0
 */
@Component
public class UrlEncode {
 public static String decodeParam(String text){
     try {
         if (StringUtils.hasText(text)){
             text = URLDecoder.decode(text, "UTF-8");
         }
     } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
     }
     return  text;
 }
    public static  String encodeParam(String text){
        try {
            if (StringUtils.hasText(text)){
                text = URLEncoder.encode(text, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  text;
    }

}
