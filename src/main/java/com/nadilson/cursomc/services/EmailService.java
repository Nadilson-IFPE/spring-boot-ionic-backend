package com.nadilson.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.nadilson.cursomc.domain.Pedido;

public interface EmailService {

	void sendorderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
