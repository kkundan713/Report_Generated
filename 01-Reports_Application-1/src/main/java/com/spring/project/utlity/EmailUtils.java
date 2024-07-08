package com.spring.project.utlity;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String subject,String body,String to,File f)throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setTo(to);
		helper.addAttachment("Plans-Info", f);
		javaMailSender.send(mimeMessage);
		System.out.println("Email Send successfully");
		return true;
	}

}
