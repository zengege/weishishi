package message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.jms.Message;

import org.json.JSONObject;

/**
 * 发送验证码
 * @author Administrator
 *
 */
public class GetMessageCode {
	private static final String QUERY_PATH = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	private static final String ACCOUNT_SID = "90448bc291174947b97acb42c20e3e40";
	private static final String AUTH_TOKEN = "aaacfd28c7114edfb01182c722131a82";
	/**
	 * 根据相应的手机号码，发送验证码
	 * @param phone
	 * @return
	 */
	public static String getCode(String phone){
		String random = smsCode();
		String timestamp   = getTimestamp();
		String sig    = getMD5(ACCOUNT_SID, AUTH_TOKEN, timestamp);
		String tamp   ="【VMall科技】登录验证码："+random+"，如非本人操作，请忽略此短信。";
		
			OutputStreamWriter out = null;
			BufferedReader br = null;
			StringBuilder result = new StringBuilder();
			try {
				URL url = new URL(QUERY_PATH);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setDoInput(true);//设置是否允许数据写入
				connection.setDoOutput(true);//设置是否允许参数输出
				connection.setConnectTimeout(5000);//设置连接响应时间
				connection.setReadTimeout(10000);//设置参数读取时间
				//Content-type:application/x-www-form-urlencoded
				connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
				//提交数据
				out = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
				String args = getQueryArgs(ACCOUNT_SID, tamp, phone, timestamp, sig,"JSON");
				out.write(args);
				out.flush();
				
				//读取返回结果
				br =  new BufferedReader(new InputStreamReader(connection.getInputStream())); 
				String temp="";
				while ((temp=br.readLine())!=null) {
					result.append(temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//JSONObject json = new JSONObject(result.toString());
			//String respCode = json.getString("respCode");
			//String defuatRespCode = "00000";
			//if(defuatRespCode.equals(respCode)){
				return random;
			//}
	//else {
			//return result.toString();
				//return defuatRespCode;
			//}
		
		
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getTimestamp(){
		
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	
	/**
	 * 参数拼接
	 * @param accountSid
	 * @param smsContent
	 * @param to
	 * @param timestamp
	 * @param sig
	 * @param respDataType
	 * @return
	 */
	public static String getQueryArgs(String accountSid,String smsContent,String to,String timestamp,String sig,String respDataType){
		String bb ="accountSid="+accountSid+"&smsContent="+smsContent+"&to="+to+"&timestamp="+timestamp+"&sig="+sig+"&respDataType="+respDataType;

		return bb;
		//02:08:33
	}
	
	/**
	 * sig签名
	 * @param sid
	 * @param token
	 * @param timestamp
	 * @return
	 */
	public static String getMD5(String sid,String token,String timestamp){
		
		StringBuilder result = new StringBuilder();
		String source = sid+token+timestamp;
		try {
		MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bytes = digest.digest(source.getBytes());
			for (byte b : bytes) {
				String hex = Integer.toHexString(b&0xff);
				if(hex.length()==1){
					result.append("0"+hex);
				}else {
					result.append(hex);
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/**
	 * 获取验证码
	 * @return
	 */
	public static String smsCode(){
		String ran = new Random().nextInt(1000000)+"";
		if(ran.length()!=6){
			return smsCode();
		}else {
			return ran;
		}
	}
	
//	public static void main(String[] args) {
//		//String time = getTimestamp();
//		//System.out.println(time);
//		
//		//String md5 = getMD5("1", "2", "3");
//		//System.out.println(md5.length());
//		
//		//for (int i = 0; i < 50; i++) {
//		//	System.out.println(smsCode());
//		//}
//		
//		String code = getCode("17670651884");
//		System.out.println(code);
//	}
}
