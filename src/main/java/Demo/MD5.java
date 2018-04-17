package Demo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String str = "configs=[]&retCode=2005&retMsg=渠道商户不存在&traceNo=xIVzbAab&key=12345678901234567890123456789012";
		
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		String newStr = base64Encoder.encode(md5.digest(str.getBytes("GBK")));
		
		System.out.println(newStr);
		
//		for (byte c : b) {
//			System.out.print(c);
//		}
		
	}
			
			

}
