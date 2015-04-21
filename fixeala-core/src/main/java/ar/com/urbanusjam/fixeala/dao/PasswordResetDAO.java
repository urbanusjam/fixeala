package ar.com.urbanusjam.fixeala.dao;

import ar.com.urbanusjam.fixeala.model.PasswordToken;

public interface PasswordResetDAO {
	
	public void saveToken(PasswordToken token);
	
	public String findUsernameByPasswordToken(String token);
	
	public void deleteToken(String token);		
	
}
