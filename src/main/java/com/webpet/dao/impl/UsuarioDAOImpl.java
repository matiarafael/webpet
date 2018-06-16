package com.webpet.dao.impl;

import com.webpet.dao.GenericDAO;
import com.webpet.dao.UsuarioDAO;
import com.webpet.domain.Usuario;
import com.webpet.util.Criptography;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author fernando
 */
@ApplicationScoped
public class UsuarioDAOImpl extends GenericDAO<Usuario, Long> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByLogin(String login) {
        String hql = "select u from Usuario u where u.email = :email";
        Query query = getEntityManager().createQuery(hql);
        query.setParameter("email", login);
        List<Usuario> usuarios = query.getResultList();
        if(CollectionUtils.isEmpty(usuarios)) {
            return null;
        } else if(usuarios.size() > 1) {
            throw new NonUniqueResultException("Mais de um usuário encontrado com o login: " + login);
        } else {
            return usuarios.get(0);
        }
    }

    @Override
    public Usuario findByCredenciais(String login, String senha) {
        String hql = "select u from Usuario u where u.email = :email and u.senha = :senha";
        Query query = getEntityManager().createQuery(hql);
        query.setParameter("email", login);
        query.setParameter("senha", Criptography.encrypt(senha));
        List<Usuario> usuarios = query.getResultList();
        if(CollectionUtils.isEmpty(usuarios)) {
            return null;
        } else if(usuarios.size() > 1) {
            throw new NonUniqueResultException("Mais de um usuário encontrado com o login: " + login);
        } else {
            return usuarios.get(0);
        }
    }

}
