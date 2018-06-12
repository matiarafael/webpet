package com.webpet.dao;

import com.webpet.domain.Usuario;

/**
 *
 * @author fernando
 */
public interface UsuarioDAO extends DAO<Usuario, Long>{
    
    Usuario findByLogin(String login);
    
    Usuario findByCredenciais(String login, String senha);
    
}
