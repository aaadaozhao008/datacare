package com.myqq.util;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 发件人账号密码
 * @author zhangdi
 *
 */
public class MailAuthenticator extends   Authenticator{

    public static String USERNAME = "441877427@qq.com";
    public static String PASSWORD = "fzojafdwofubbgjh";

    public MailAuthenticator() {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }

}