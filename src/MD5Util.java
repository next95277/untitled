import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 任务号1032
 * @ClassName: MD5Util 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author haowanshuai
 * @date 2014-10-27 上午10:51:52 
 *
 */
public class MD5Util {

	public static void main(String[] args) {
//		String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//				"<pay_interaction><response><head><serverdatetime>2019-11-22 14:21:55</serverdatetime><ver>1.0</ver></head><result><return_code>00000</return_code><return_msg>成功</return_msg><gmt_create>2019-11-22 14:18:40</gmt_create><out_trade_no>0120191122000008</out_trade_no><out_trade_date>20191122</out_trade_date><pay_order_no>2019112201000236799</pay_order_no><process_date>2019-11-22 14:21:55</process_date><trade_status>05</trade_status><extension>备注信息无</extension><pay_date>2019-11-22 14:21:55</pay_date><electronicAccountNo>6214627359000021323</electronicAccountNo></result></response></pay_interaction>";
//		String key = "6878e62b1a67d5e148fb56becd63ee17";
//		String signature = xmlData + key;
//		String md5Signature = MD5Util.MD5Encode(signature, "utf-8");
//		System.out.println(md5Signature);

//		String a = "a";
//		String b = "";
//		String c = "c";
//		System.out.println(a + b + c);

//		String type = "2";
//		String ecNo = "7448187409841698";
//		String referInfo = "";
//		String partnerid = "1002201511103800";
//		String key = "dd70c69876cf7e788537742c1b4faabc";
//		String encode = type+ecNo+referInfo+partnerid+key;
//		String sign = MD5Util.MD5Encode(encode , "UTF-8");
//		String redirectUri = "http://10.18.59.35:8090/mobileapp/chinaLife/appServiceActionController/service.do" + "?serviceCode=22&ecNo=" + ecNo + "&partnerId=" + partnerid + "&type=2&Sign=" +sign;
//		System.out.println(redirectUri);

		String str1 = "hello";
		String str2 = "he"+new String("llo");
		System.out.println(str1 == str2);
		System.out.println(str1);
		System.out.println(str2);
	}


	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
//============cx_1063	一帐通国寿钱包	yangbo  2015-9-09========  start  =============================	    
	/**
	 * @version	cx_1063      一帐通国寿钱包加密    
	 * @date	2015-09-09
	 * @author	yangbo
	 * @param	data
	 * @return
	 */
    public static String md5(String data) {
    	System.out.println("进入转码方法(^_^)");
        MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
			System.out.println("转码出现异常啦!(^o^)");
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }

        try {
            msgDigest.update(data.getBytes("utf-8"));

        } catch (UnsupportedEncodingException e) {
			System.out.println("转码出现异常啦!(^o^)");
            throw new IllegalStateException("System doesn't support your  EncodingException.");

        }

        byte[] bytes = msgDigest.digest();

        String md5Str = new String(encodeHex(bytes));

        return md5Str;
    }

	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

  	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
      'b', 'c', 'd', 'e', 'f'   };
//============cx_1063	一帐通国寿钱包	yangbo  2015-9-09========   end  =============================

}
