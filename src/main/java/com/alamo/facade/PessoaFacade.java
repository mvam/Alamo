package com.alamo.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alamo.domain.Usuario;
import com.alamo.rn.UsuarioRN;

/**
 * @author Marcos Moreira
 *
 */
@Service("pessoaFacade")
public class PessoaFacade {
	
	private UsuarioRN usuarioRN;
	
	@Autowired
	public PessoaFacade(
			@Qualifier("usuarioRN") final UsuarioRN usuarioRN
			) {
		this.usuarioRN = usuarioRN;
	}

	/*******************************USUARIO******************************/
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRN.salvarUsuario(usuario);
	}
	/*****************************USUARIO FIM****************************/
}
