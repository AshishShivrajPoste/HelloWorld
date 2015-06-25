package com.ashish.edu.crawler;

/**
 * 
 * @author Ashish S Poste
 *
 */
public interface LinkHandler {

	/**
	 * Place the link in Queue
	 * @param url
	 */
	public void queueLink(String url) throws Exception;
	/**
	 * Return the number of visited links;
	 * @return
	 */
	public int size();
	/**
	 * check if link already visited
	 * @param url
	 * @return
	 */
	public Boolean isVisited(String url);
	/***
	 * Mark the link as Visited
	 * @param url
	 */
	public void markVisited(String url);
}
