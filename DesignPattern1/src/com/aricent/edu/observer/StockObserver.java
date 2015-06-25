package com.aricent.edu.observer;

public class StockObserver implements Observer {

	private double ibmPrice;
	private double applePrice;
	private double googlePrice;
	
	private static int observerIDTracker = 0;
	private int observerID;
	private Subject stockGrabber;
	
	public StockObserver(Subject stockGrabber){
		this.stockGrabber = stockGrabber;
		this.observerID = ++observerIDTracker;
		System.out.println("New Observer "+this.observerID);
		stockGrabber.register(this);
	}
	@Override
	public void update(double ibmPrice, double applePrice, double googlePrice) {

			this.ibmPrice = ibmPrice;
			this.applePrice = applePrice;
			this.googlePrice = googlePrice;
			
			printStockPrices();
	}
	private void printStockPrices() {
		System.out.println(observerID + "\nIBM=="+ibmPrice+"\nAPPLE=="+applePrice+"\nGoogle=="+googlePrice);
	}

}
