package com.aricent.edu.observer;

public class GrabStocks {

		public static void main(String[] args){
			StockGrabber stockGrabber = new StockGrabber();
			
			StockObserver observer =new StockObserver(stockGrabber);
			
			stockGrabber.setApplePrice(156.70);
			stockGrabber.setGooglePrice(345.23);
			stockGrabber.setIbmPrice(542.12);
			
			Runnable getIBM = new GetTheStock(stockGrabber, "IBM", 197.20, 2);
			Runnable getApple = new GetTheStock(stockGrabber, "APPLE", 1234.20, 2);
			Runnable getGoogle = new GetTheStock(stockGrabber, "GOOGLE",645.45, 2);
			
			new Thread(getIBM).start();
			new Thread(getApple).start();
			new Thread(getGoogle).start();
		}
}


