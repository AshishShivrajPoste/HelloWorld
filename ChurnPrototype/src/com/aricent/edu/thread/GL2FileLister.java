package com.aricent.edu.thread;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GL2FileLister implements Runnable{

	private static ConcurrentHashMap<String, GL2FileLister> gl2fillisterMap = new ConcurrentHashMap<>();
	private CopyOnWriteArrayList<String> listofFiles = null;
	public GL2FileLister(CopyOnWriteArrayList<String> listofFiles){
		this.listofFiles = listofFiles;
	}
	@Override
	public void run() {
		System.out.println("Hello world i am sad!!!!!");
		getGl2fillisterMap().put(this.toString(), this);
		checkforduplicateFiles(this);
		System.out.println("Thread-->"+Thread.currentThread()+ " has files " +listofFiles);
		
	}
//	private  void checkforduplicateFiles(GL2FileLister fileLister){
//		Collection<GL2FileLister> list = getGl2fillisterMap().values();
//		for(GL2FileLister thread:list){
//			if(thread!=fileLister){
//				synchronized (thread.listofFiles)
//				 {
//					for(String str : fileLister.listofFiles){
//						if(thread.listofFiles.contains(str)){
//							System.out.println("Removing String--->"+str);
//							fileLister.listofFiles.remove(str);	
//						}
//					}
//					System.out.println("check--->"+fileLister.listofFiles);
//					gl2fillisterMap.put(this.toString(), fileLister);
//				}
//			}
//		}
//		
//	}
//	private void checkforduplicateFiles(GL2FileLister fileLister){
//		Collection<GL2FileLister> list = getGl2fillisterMap().values();
//		synchronized (gl2fillisterMap.values())
//		{
//		for(GL2FileLister thread:list){
//			synchronized (thread.listofFiles) {
//				if(thread!=fileLister){
//					for(String str : fileLister.listofFiles){
//						if(thread.listofFiles.contains(str)){
//							System.out.println("Removing String--->"+str);
//							fileLister.listofFiles.remove(str);	
//						}
//					}
//				}
//			}
//			}
//			System.out.println("check--->"+fileLister.listofFiles);
//			gl2fillisterMap.put(this.toString(), fileLister);
//		}
//	}
	
	private static synchronized  void checkforduplicateFiles(GL2FileLister fileLister){
		Collection<GL2FileLister> list = getGl2fillisterMap().values();
//		synchronized (fileLister.listofFiles)
//		{
			for(GL2FileLister thread:list){
//				synchronized (thread.listofFiles) {
					if(thread!=fileLister){
						for(String str : fileLister.listofFiles){
								if(thread.listofFiles.contains(str)){
									System.out.println("Removing String--->"+str);
									fileLister.listofFiles.remove(str);	
							}
						}
					}
//				}
			}
			System.out.println("check--->"+fileLister.listofFiles);
			gl2fillisterMap.put(fileLister.toString(), fileLister);
//		}
	}
	public static ConcurrentHashMap<String, GL2FileLister> getGl2fillisterMap() {
		return gl2fillisterMap;
	}
	public static void setGl2fillisterMap(ConcurrentHashMap<String, GL2FileLister> gl2fillisterMap) {
		GL2FileLister.gl2fillisterMap = gl2fillisterMap;
	}

}
