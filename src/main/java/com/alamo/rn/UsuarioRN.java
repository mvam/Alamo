package com.alamo.rn;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamo.dao.UsuarioDAO;
import com.alamo.domain.Usuario;

@Service("usuarioRN")
public class UsuarioRN {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		//RN 1 - A senha do usuario deve ser criptografada
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
			usuario.setSenha(new String(messageDigest, "UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return usuarioDAO.create(usuario);
	}
}
