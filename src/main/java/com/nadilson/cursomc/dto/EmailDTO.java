package com.nadilson.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(message="Email inválido!")
	private String email;

	public EmailDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
