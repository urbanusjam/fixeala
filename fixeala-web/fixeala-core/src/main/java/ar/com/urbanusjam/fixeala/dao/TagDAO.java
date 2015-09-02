package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.Tag;

public interface TagDAO {
		
	public List<Tag> getTags();
	public boolean tagExists(String tagname);	
	public Tag findTagByName(String tagname);
	public void deleteTag(Tag tag);
	public void saveTags(String[] tags);

}
