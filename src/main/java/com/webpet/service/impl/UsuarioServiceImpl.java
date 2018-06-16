package com.webpet.service.impl;

import com.webpet.dao.DAO;
import com.webpet.dao.UsuarioDAO;
import com.webpet.domain.Usuario;
import com.webpet.service.GenericCRUDRestService;
import com.webpet.service.UsuarioService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fernando
 */
@ManagedBean
@Path("/usuario")
public class UsuarioServiceImpl extends GenericCRUDRestService<Usuario> implements UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;
    
    public UsuarioServiceImpl() {
        super(Usuario.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Usuario> list) {
        return new GenericEntity<List<Usuario>>(list){};
    }

    @Override
    public DAO getDao() {
        return usuarioDAO;
    }

    @GET
    @Path("/email/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByEmail(String email) {
        getLogger().debug("Buscando usuário pelo email: {}", email);
        Usuario found = usuarioDAO.findByLogin(email);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

    @GET
    @Path("/login/{username}/{password}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByCredenciais(String email, String senha) {
        getLogger().debug("Buscando usuário pelo email: {}", email);
        Usuario found = usuarioDAO.findByCredenciais(email, senha);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }

}
