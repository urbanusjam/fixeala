package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.Comment;

public interface CommentDAO {
	
	public List<Comment> findCommentsByIssueId(Long issueID);
	
	public void saveComment(Comment comment);

}
