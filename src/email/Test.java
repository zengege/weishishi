package email;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public  class Test {
	
	public static String email(String mail){
		StringBuffer sb = new StringBuffer();
		
		Random random = new Random();
		for(int i=0;i<4;i++){
			int k = random.nextInt(10);
			sb.append(k+"");
		}
		String code = sb.toString();
		{
			String qm ="jkewttoxpgaebeei"; //您的QQ密码
			String tu = "qq.com"; //你邮箱的后缀域名
			String tto=mail; //接收邮件的邮箱
			String ttitle="欢迎注册";
			String tcontent="验证码是："+code;
			Properties props=new Properties();
			props.put("mail.smtp.host","smtp."+tu);//发信的主机，这里我填写的是我们公司的主机！可以不用修改！
			props.put("mail.smtp.auth","true");
			Session s=Session.getInstance(props);
			s.setDebug(true);
			MimeMessage message=new MimeMessage(s);
			//给消息对象设置发件人/收件人/主题/发信时间
			try {
				InternetAddress from=new InternetAddress("1009951653@"+tu); //这里的115798090 改为您发信的QQ号
				message.setFrom(from);
				InternetAddress to=new InternetAddress(tto);
				message.setRecipient(Message.RecipientType.TO,to);
				message.setSubject(ttitle);
				message.setSentDate(new Date());
				//给消息对象设置内容
				BodyPart mdp=new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
				mdp.setContent(tcontent,"text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
				Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
				//象(事实上可以存放多个)
				mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
				message.setContent(mm);//把mm作为消息对象的内容
				message.saveChanges();
				Transport transport=s.getTransport("smtp");
				transport.connect("smtp."+tu,"1009951653",qm); //这里的115798090也要修改为您的QQ号码
				transport.sendMessage(message,message.getAllRecipients());
				transport.close();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return code;
	}

}

