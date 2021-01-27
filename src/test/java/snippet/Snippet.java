package snippet;

import com.myqq.util.MailOperation;
import com.myqq.util.RandomUtil;

public class Snippet {
	   public static void main(String[] args) {
	
	        MailOperation operation = new MailOperation();
	        String user = "老牛在哪";
	        String password = "fzojafdwofubbgjh";
	        String host = "pop.qq.com";//pop.qq.com
	        String from = "441877427@qq.com";
	        String to = "441877427@qq.com";// 收件人
	        String subject = "test";
	        //邮箱内容
	        StringBuffer sb = new StringBuffer();
	        String yzm = RandomUtil.getRandomString(6);
	        sb.append("<!DOCTYPE>"+"<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
	                          + "<div style='width:950px;font-family:arial;'>欢迎使用NET微活动，您的注册码为：<br/><h2 style='color:green'>"+yzm+"</h2><br/>本邮件由系统自动发出，请勿回复。<br/>感谢您的使用。<br/>杭州恩意替电子商务有限公司</div>"
	                         +"</div>");
	        try {
	            String res = operation.sendMail(user, password, host, from, to,
	                    subject, sb.toString());
	            System.out.println(res);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
}

