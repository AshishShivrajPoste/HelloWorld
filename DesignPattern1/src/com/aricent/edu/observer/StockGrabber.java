package com.aricent.edu.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

	private List<Observer> observers = null;
	private double ibmPrice;
	private double applePrice;
	private double googlePrice;
	
	public StockGrabber(){
		observers = new ArrayList<Observer>();
	}
	@Override
	public void register(Observer newOnserver) {
		observers.add(newOnserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		
		int observerIndex = observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.update(ibmPrice, applePrice, googlePrice);
		}
	}
	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObservers();
	}
	public void setApplePrice(double applePrice) {
		this.applePrice = applePrice;
		notifyObservers();
	}
	public void setGooglePrice(double googlePrice) {
		this.googlePrice = googlePrice;
		notifyObservers();
	}	
}
