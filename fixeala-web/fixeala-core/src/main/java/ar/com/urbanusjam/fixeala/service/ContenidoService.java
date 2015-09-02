package ar.com.urbanusjam.fixeala.service;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.MediaContent;


public interface ContenidoService {
	 
	public List<MediaContent> getIssueFiles(String issueID);
	
	public MediaContent getUserPic(String username);
	 
    public void uploadFiles(List<MediaContent> files, String issueID, String username);
    
    public void uploadUserPic(MediaContent file);
    
    public void deleteFiles(List<String> files, String issueID);
        
}
