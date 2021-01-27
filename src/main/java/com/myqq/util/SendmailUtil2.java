package com.myqq.util;
import java.util.Date;
import java.util.Properties;
 
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
 
/**
 * 创建并发送一封包含文本、图片、附件的复杂邮件。ps：下面的QQ账号密码都不是真是的！
 * JavaMail 版本: 1.6.0
 * JDK 版本: JDK 1.7 以上（必须）
 */
public class SendmailUtil2 {
 
    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    public static String myEmailAccount = "441877427@qq.com";
    public static String myEmailPassword = "fzojafdwofubbgjh";//这个密码不是QQ密码或者邮箱密码，要验证的。自己百度
 
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般格式为: smtp.xxx.com
    // qq邮箱的 SMTP 服务器地址为: smtp.qq.com
    public static String myEmailSMTPHost = "smtp.qq.com";
 
    public static void main(String[] args) throws Exception {
    	String email = "498833271@qq.com";
    	String string = sendMessages(email);
    	System.out.println(string);
    }
    public static String sendMessages(String email) {
    	  // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
 
        // 开启 SSL 连接, 以及更详细的发送步骤请看上一篇: 基于 JavaMail 的 Java 邮件发送：简单邮件发送
        //QQ邮箱端口有两个，可以百度。
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
         
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
//        session.setDebug(true);
        // 3. 创建一封邮件
        MimeMessage message;
		try {
			message = createMimeMessageForYzm(session, myEmailAccount, email);
			// 也可以保持到本地查看
			// message.writeTo(file_out_put_stream);
			// 4. 根据 Session 获取邮件传输对象
			Transport transport = session.getTransport();
			// 5. 使用 邮箱账号 和 密码 连接邮件服务器
			//    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
			transport.connect(myEmailAccount, myEmailPassword);
			// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
			transport.sendMessage(message, message.getAllRecipients());
			// 7. 关闭连接
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
 
        return "验证码已发送邮箱,请注意查收";
    	
    }
    /**创建一封邮件邮件（验证吗）*/
    
    public static MimeMessage createMimeMessageForYzm(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建邮件对象
        MimeMessage message = new MimeMessage(session);
 
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "我的测试邮件_发件人昵称", "UTF-8"));
 
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.addRecipient(RecipientType.TO, new InternetAddress(receiveMail, "我的测试邮件_收件人昵称", "UTF-8"));
 
        // 4. Subject: 邮件主题
        message.setSubject("欢迎注册本系统,请查收您的验证码", "UTF-8");

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        
        //文字区
        
        MimeBodyPart tex_yzm = new MimeBodyPart();
        StringBuffer sb = new StringBuffer();
        String yzm = RandomUtil.getRandomString(6);
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                          + "<div style='width:950px;font-family:arial;'>"
                          + "欢迎使用婉尚好 微服务活动，您的注册码为：<br/><h2 style='color:green'>"+yzm+"</h2><br/>"
                          		+ "本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>鹤壁荔枝电子商务有限公司</div>"
                         +"</div>");
        tex_yzm.setContent(sb.toString(), "text/html;charset=utf-8");
      /**
      * 验证码要保存
      */
        mm.addBodyPart(tex_yzm);
        
        message.setContent(mm);
 
        // 12. 设置发件时间 
        message.setSentDate(new Date());
 
        // 13. 保存上面的所有设置
        message.saveChanges();
 
        return message;
    }
    /**创建一封邮件邮件（文本+图片+附件）*/
      
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建邮件对象
        MimeMessage message = new MimeMessage(session);
 
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "我的测试邮件_发件人昵称", "UTF-8"));
 
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.addRecipient(RecipientType.TO, new InternetAddress(receiveMail, "我的测试邮件_收件人昵称", "UTF-8"));
 
        // 4. Subject: 邮件主题
        message.setSubject("TEST邮件主题（文本+图片+附件）", "UTF-8");

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        
        //文字区
        
        MimeBodyPart tex_yzm = new MimeBodyPart();
        StringBuffer sb = new StringBuffer();
        String yzm = RandomUtil.getRandomString(6);
        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                          + "<div style='width:950px;font-family:arial;'>欢迎使用NET微活动，您的注册码为：<br/><h2 style='color:green'>"+yzm+"</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>杭州恩意替电子商务有限公司</div>"
                         +"</div>");
        tex_yzm.setContent(sb.toString(), "text/html;charset=utf-8");
        mm.addBodyPart(tex_yzm);
        
        //图片区 可以加文字
        MimeBodyPart text_image = new MimeBodyPart();
      
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Pictures\\d42404ca7bcb0a46e05ec46c6663f6246a60afbb.jpg")); // 读取本地文件
        image.setDataHandler(dh);                   // 将图片数据添加到“节点”
        image.setContentID("image_fairy_tail");     // 为“节点”设置一个唯一编号（在文本“节点”将引用该ID）
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("哈哈<br/><img src='cid:image_fairy_tail'/>", "text/html;charset=UTF-8");
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系
        
        text_image.setContent(mm_text_image);
        mm.addBodyPart(text_image);
        //下载区
        MimeBodyPart attachment = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("F:\\Users\\义教五个\\04 数据 Datasift data.xlsx"));  // 读取本地文件
        attachment.setDataHandler(dh2);                                             // 将附件数据添加到“节点”
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // 设置附件的文件名（需要编码）
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系

        message.setContent(mm);
 
        // 12. 设置发件时间 
        message.setSentDate(new Date());
 
        // 13. 保存上面的所有设置
        message.saveChanges();
 
        return message;
    }
 
}