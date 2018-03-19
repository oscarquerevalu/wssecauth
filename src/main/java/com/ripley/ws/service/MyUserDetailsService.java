package com.ripley.ws.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ripley.ws.model.Usuariosms;
import com.ripley.ws.repo.UsuariosmsRepository;

/**
 * @author oquerevalu
 * Dec 14, 2017
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UsuariosmsRepository usuariosmsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		Usuariosms user = usuariosmsRepository.findByUsuario(usuario);
		
		if(user == null) throw new UsernameNotFoundException("Usuario no existe");
		
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol());
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsuario(),
				user.getPassword(), Arrays.asList(authority));
		
		return userDetails;
	}

}
