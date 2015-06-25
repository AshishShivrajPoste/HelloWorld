package com.ashish.edu.crawler;
/**
 * @author Ashish S Poste
 */
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawler6 implements LinkHandler{

	private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
	private String startingUrl;
	private ExecutorService executorPool = null;
	/**
	 * Initialisation of executorPool and startingUrl
	 * @param startingUrl : Initial URL to start Crawling
	 * @param maxThreads : Number of worker threads in ExecutorService pool
	 */
	public WebCrawler6(String startingUrl , int maxThreads){
		this.startingUrl = startingUrl;
		executorPool = Executors.newFixedThreadPool(maxThreads);
	}
	
	@Override
	public void queueLink(String url) throws Exception {
		startNewThread(url);
	}

	@Override
	public int size() {
		return visitedLinks.size();
	}

	@Override
	public Boolean isVisited(String url) {
		return visitedLinks.contains(url);
	}

	@Override
	public void markVisited(String url) {
		visitedLinks.add(url);
		
	}
	private void startNewThread(String url) throws Exception {
		executorPool.execute(new LinkFinder(url,this));
	}
	private void startCrawling(String url) throws Exception{
		startNewThread(url);
	}
	
}
