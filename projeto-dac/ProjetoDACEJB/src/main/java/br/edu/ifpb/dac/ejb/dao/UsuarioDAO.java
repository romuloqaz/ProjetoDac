package br.edu.ifpb.dac.ejb.dao;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.edu.ifpb.dac.ejb.entidades.Usuario;

@Stateless
public class UsuarioDAO {
	
	private static final Logger log = Logger.getLogger(Logger.class.getName());
	
	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Usuario u) {
		em.persist(u);
	}

	public void atualizar(Usuario p) {
		em.merge(p);
	}

	public Usuario buscar(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public Optional<Usuario> buscarPorLogin(String login) {
		Optional<Usuario> usuario = Optional.empty();
		try {
			usuario = Optional.ofNullable((Usuario)em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login").setParameter("login", login).setMaxResults(1).getSingleResult());
		} catch(NoResultException e) {
			log.log(Level.WARNING, "Nenhum resultado encontrado para este login");
		}
		return usuario;
	}

	public List<Usuario> buscarTodos() {
		return em.createQuery("SELECT u FROM Usuario u ORDER BY u.id", Usuario.class).getResultList();
	}

}
