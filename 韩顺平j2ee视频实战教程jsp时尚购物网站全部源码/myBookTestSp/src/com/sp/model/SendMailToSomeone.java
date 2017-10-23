package com.sp.model;

public class SendMailToSomeone {

	/**
	 * 发送电子邮件到指定的信箱
	 * @param title 邮件标题 
	 * @param mailbody 邮件内容
	 * @param sendTo 发送给谁
	 * @param from 从哪些发送
	 * @param passwd 密码
	 * @param sendStmp 发送邮件的smtp
	 */
	public void send(String title,String mailbody,String sendTo,String from,String passwd,String sendStmp){
		
		//指明让那个smtp转发(搜狐)
		MysendMail themail = new MysendMail("smtp.sohu.com");
		
		//校验身份
		themail.setNeedAuth(true);
		
		//邮件标题
		if(themail.setSubject(title) == false) return;
		//将要发送的 内容放入邮件体 
		if(themail.setBody(mailbody) == false) return;
		
		//发送到哪里
		if(themail.setTo(sendTo) == false) return;
		
		//谁发送的
		if(themail.setFrom("ping-han@sohu.com") == false) return;
	
	
	//	if(themail.addFileAffix("e:\\butterfly.gif") == false) return;
		
			
	//	if()
		//将在sohu网站上的邮件用户名和 密码 放入邮件体 
		themail.setNamePass("ping-han","13621219321");
		
		//发送
		if(themail.sendout() == false) return;
	}
}
