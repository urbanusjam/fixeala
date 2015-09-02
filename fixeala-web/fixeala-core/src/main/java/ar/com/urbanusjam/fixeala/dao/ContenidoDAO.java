package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.MediaContent;

public interface ContenidoDAO {
	
	public void saveContenidos(List<MediaContent> contenidos);
	
	public List<MediaContent> findContenidosByIssue(Long idIssue);	
	
	public MediaContent findProfilePic(String username);
	
	public boolean deleteContenido(Long issueID, String fileID);
	
	public boolean deleteProfilePic(String fileID, String username);
	
}
