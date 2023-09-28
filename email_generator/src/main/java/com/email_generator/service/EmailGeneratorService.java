package com.email_generator.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailGeneratorService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public String sendMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("mail@gmail.com");
		simpleMailMessage.setCc("mail1@gmail.com","mail2@gmail.com");
		simpleMailMessage.setSubject("Email Generation");
		simpleMailMessage.setText("Hi All,\n\n"
				+ "This mail is generated through smtp."
				+ "\n\nThanks & Regards\nG Nandhavardhan Reddy");
		javaMailSender.send(simpleMailMessage);
		return "mail sended";
	}

	public String sendMailWithAttachment() {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo("mail@gmail.com");
			String[] cc = {"mail1@gmail.com","mail2@gmail.com"};
			mimeMessageHelper.setCc(cc);
			mimeMessageHelper.setSubject("Email Generation");
			mimeMessageHelper.setText("Hi All,\n\n"
					+ "This mail is generated through smtp with attachment."
					+ "\n\nThanks & Regards\nG Nandhavardhan Reddy");
			FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\Admin\\Desktop\\PdfGeneration\\demo1.pdf"));
			mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
			javaMailSender.send(mimeMessage);
			return "mail sended";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "not sended";
		}
		
	}

	
}
