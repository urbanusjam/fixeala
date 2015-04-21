package ar.com.urbanusjam.fixeala.dao;

import ar.com.urbanusjam.fixeala.model.IssuePageView;

public interface IssuePageViewDAO {
	
	public void saveIssuePageView (IssuePageView pageview);
	
	public int getIssuePageViews (Long issueID);
	
	public boolean existsIssuePageView (Long issueID, String username);

}
