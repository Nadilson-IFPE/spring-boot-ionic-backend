package com.nadilson.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nadilson.cursomc.domain.Cliente;
import com.nadilson.cursomc.repositories.ClienteRepository;
import com.nadilson.cursomc.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    Cliente cli = repo.findByEmail(email);
	    if (cli == null) {
	    	throw new UsernameNotFoundException(email);
	    }
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
