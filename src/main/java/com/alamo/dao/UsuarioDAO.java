package com.alamo.dao;

import org.springframework.stereotype.Repository;

import com.alamo.domain.Usuario;

/**
 * @author Marcos Moreira
 *
 */
@Repository("usuarioDAO")
public class UsuarioDAO extends AbstractJpaDAO<Usuario, Long>{

}
