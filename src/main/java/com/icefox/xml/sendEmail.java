package com.icefox.xml;

import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;

public class sendEmail {
	
	public static void main(String[] args) {
		SmtpClient client = new SmtpClient("smtp.ym.163.com", 25, "admin@renrencui.org",
				"acheng123.com", SecurityOptions.Auto);

		String content = "内容";
		MailMessage msg = new MailMessage("admin@renrencui.org", "lhxlihongxiang@126.com", "海洋信用邮件认证", content);
		client.send(msg);
	}
	
}
