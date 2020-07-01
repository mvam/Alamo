package com.alamo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.alamo.domain.Usuario;
import com.alamo.util.Util;

/**
 * @author Marcos Moreira
 *
 */
@ManagedBean
@RequestScoped
public class UsuarioBean extends BaseBean {

	private Usuario usuario;

	public void salvar() {
//		this.getPessoaFacade().salvarUsuario(usuario);
	}

	public Usuario getUsuario() {
		if(Util.isEmptyOrNull(usuario)) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
