package ar.com.urbanusjam.fixeala.dao;

import ar.com.urbanusjam.fixeala.model.ActivationToken;


public interface ActivationDAO {
	
	public void saveToken(ActivationToken token);
	
	public String findUsernameByActivationToken(String token);
	
	public void deleteToken(String token);
	
	public void deleteTokenByUsername(String username);	
	
}
