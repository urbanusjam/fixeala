package ar.com.urbanusjam.fixeala.dao;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import ar.com.urbanusjam.fixeala.model.Authority;

public interface AuthorityDAO {
	
	public Authority getRoleById(Long id);
	public Authority getRoleByName(String rolename);
	public void saveAuthorities(String username, Collection<GrantedAuthority> authorities);

}
