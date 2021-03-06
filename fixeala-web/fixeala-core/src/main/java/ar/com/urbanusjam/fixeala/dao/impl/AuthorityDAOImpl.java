package ar.com.urbanusjam.fixeala.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.urbanusjam.fixeala.dao.AuthorityDAO;
import ar.com.urbanusjam.fixeala.model.Authority;
import ar.com.urbanusjam.fixeala.model.AuthorityPK;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO  {
	
	@PersistenceContext(unitName = "fixealaPU")
	private EntityManager entityManager;   
	
	public AuthorityDAOImpl() {}
	
	@Override
	public Authority getRoleById(Long id){
		Authority rol = entityManager.createQuery("SELECT a FROM Authority a WHERE a.id = :id ", Authority.class)
				  					 .setParameter("id", id)			
				  					 .getSingleResult();	
		return rol;
	}
	
	@Override
	public Authority getRoleByName(String rolename){
		Authority rol = entityManager.createQuery("SELECT a FROM Authority a WHERE a.authority = :rolename ", Authority.class)
					 .setParameter("rolename", rolename)			
					 .getSingleResult();	
		return rol;
	}	
	
	@Override
	@Transactional
	public void saveAuthorities(String username, Collection<GrantedAuthority> authorities) {
		for(GrantedAuthority auth : authorities){
			AuthorityPK id = new AuthorityPK();			
			id.setUsername(username);
			id.setAuthority(auth.getAuthority());
			Authority a = new Authority();			
			entityManager.persist(a);
		}
	}


}
