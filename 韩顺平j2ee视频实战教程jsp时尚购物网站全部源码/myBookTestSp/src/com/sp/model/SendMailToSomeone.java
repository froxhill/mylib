package com.sp.model;

public class SendMailToSomeone {

	/**
	 * ���͵����ʼ���ָ��������
	 * @param title �ʼ����� 
	 * @param mailbody �ʼ�����
	 * @param sendTo ���͸�˭
	 * @param from ����Щ����
	 * @param passwd ����
	 * @param sendStmp �����ʼ���smtp
	 */
	public void send(String title,String mailbody,String sendTo,String from,String passwd,String sendStmp){
		
		//ָ�����Ǹ�smtpת��(�Ѻ�)
		MysendMail themail = new MysendMail("smtp.sohu.com");
		
		//У�����
		themail.setNeedAuth(true);
		
		//�ʼ�����
		if(themail.setSubject(title) == false) return;
		//��Ҫ���͵� ���ݷ����ʼ��� 
		if(themail.setBody(mailbody) == false) return;
		
		//���͵�����
		if(themail.setTo(sendTo) == false) return;
		
		//˭���͵�
		if(themail.setFrom("ping-han@sohu.com") == false) return;
	
	
	//	if(themail.addFileAffix("e:\\butterfly.gif") == false) return;
		
			
	//	if()
		//����sohu��վ�ϵ��ʼ��û����� ���� �����ʼ��� 
		themail.setNamePass("ping-han","13621219321");
		
		//����
		if(themail.sendout() == false) return;
	}
}
