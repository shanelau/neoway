package cn.neoway.common.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-6
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
public class SendMail {
    private static  SimpleMailSender sms;
    private static String serverHost;
    private static String serverPort;
    private static String userName;
    private static String password;
    private static SendMail sendMail;

    private SendMail() {
        sms = new SimpleMailSender();
        init();
    }
    public  static SendMail getInstatnce(){
          if(sendMail == null){
              sendMail = new SendMail();
          }
        return sendMail;
    }

    public static void main(String[] args){
              new SendMail().sendMail("发给你", "测试邮件", "kissliux@qq.com");
    }
    public void sendMail(String title,String content,String toAddress){

        sms.sendTextMail(getSimpleMailInfo(title,content,toAddress));//发送文体格式
    }
    public void sendHtmlMail(String title,String content,String toAddress){

        sms.sendHtmlMail(getSimpleMailInfo(title,content,toAddress));//发送html格式
    }
    public static void init(){
        InputStream inputStream = SendMail.class.getClassLoader().getResourceAsStream("mail.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            serverHost = p.getProperty("mail.server.host");
            serverPort = p.getProperty("mail.server.post");
            userName = p.getProperty("mail.username");
            password = p.getProperty("mail.password");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public MailSenderInfo getSimpleMailInfo(String title,String content,String toAddress){
        //这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(serverHost);
        mailInfo.setMailServerPort(serverPort);
        mailInfo.setValidate(true);
        mailInfo.setUserName(userName);
        mailInfo.setPassword(password);//您的邮箱密码
        mailInfo.setFromAddress(userName);
        mailInfo.setSubject(title);
        mailInfo.setContent(content);
        mailInfo.setToAddress(toAddress);
        return mailInfo;
    }

    public static String getUserName() {
        return userName;
    }
}
