package com.ripley.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripley.ws.model.Usuariosms;
import com.ripley.ws.repo.UsuariosmsRepository;

/**
 * @author oquerevalu
 * Dec 14, 2017
 */
@Service
public class UsuariosmsService{

	@Autowired
    private UsuariosmsRepository usuariosmsRepository;
	
	public Usuariosms findById(String id) {
		
		return usuariosmsRepository.findById(id);
	}
	
	public String findId(String id) {
		
		return usuariosmsRepository.findId(id);
	}

}
