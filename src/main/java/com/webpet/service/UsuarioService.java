package com.webpet.service;

import com.webpet.domain.Usuario;
import javax.ws.rs.core.Response;

/**
 *
 * @author fernando
 */
public interface UsuarioService extends CRUDRestService<Usuario> {
    
    Response getByEmail(String email);
    
    Response getByCredenciais(String email, String senha);
    
}
