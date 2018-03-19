package com.ripley.ws.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ripley.ws.model.Usuariosms;
/**
 * @author oquerevalu
 * Dec 14, 2017
 */
public interface UsuariosmsRepository extends JpaRepository<Usuariosms, Long>{
	
	 Usuariosms findByUsuario(String usuario);
	 
	 Usuariosms findById(String id);
	 
	 public static final String FIND_ID = "SELECT MAX(id) FROM usrsegserws WHERE id = ?1";

	 @Query(value = FIND_ID, nativeQuery = true)
	 public String findId(String id);

}
