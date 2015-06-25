package com.aricent.edu.observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {

	private int startTime;
	private String stock;
	private double price;
	
	private Subject stockGrabber = null;
	
	public GetTheStock(StockGrabber stockGrabber,String stock,double price,int startTime){
		this.stockGrabber = stockGrabber;
		this.price = price;
		this.startTime = startTime;
		this.stock = stock;
	}
	@Override
	public void run() {
		for(int i = 1; i <= 20; i++){
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ex){}
			double randomNumber = (Math.random() * (.06)) - 0.30;
			DecimalFormat df = new DecimalFormat("#.##");
			price  = Double.valueOf(df.format(price + randomNumber));
			if(stock == "IBM"){
				((StockGrabber) stockGrabber).setIbmPrice(price);
			}
			if(stock == "APPLE"){
				((StockGrabber) stockGrabber).setApplePrice(price);
			}
			if(stock == "GOOGLE"){
				((StockGrabber) stockGrabber).setGooglePrice(price);
			}
			System.out.println(stock + ":"+df.format(price + randomNumber) + " " + df.format(randomNumber));
			System.out.println();
		}
		
	}
}
