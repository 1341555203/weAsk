package cn.qtech.mtf.common.persistence.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.UUID;

/**
 *字符转换类
 */
public class EncodeUtil {
	//使用MD5加密
	public static String EncodeByMd5(String str) {
//		确定加密方法
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			//加密后的字符串
			String newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//使用UUID获得存储使用的文件名
	public static String EncodeFileName(String fileName) {
		int index = fileName.lastIndexOf(".");
		String ext = "";
		if (index > -1) {
			ext = fileName.substring(index);
		}
		return UUID.randomUUID() + ext;
	}

}
