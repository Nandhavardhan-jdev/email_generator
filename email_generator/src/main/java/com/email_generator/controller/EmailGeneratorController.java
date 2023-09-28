package com.email_generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email_generator.service.EmailGeneratorService;

@RestController
@RequestMapping("email/generator")
public class EmailGeneratorController {

	@Autowired
	EmailGeneratorService emailGeneratorService;
	
	@GetMapping("/send/mail")
	public String sendMail() {
		return emailGeneratorService.sendMail();
	}
	
	@GetMapping("/send/mail/with/attachment")
	public String sendMailWithAttachment() {
		return emailGeneratorService.sendMailWithAttachment();
	}
}
