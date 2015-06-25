package com.aricent.edu.factory;

public abstract class EnemyShip {

	private String name = null;
	private String damage = null;
	
	public EnemyShip(String name,String damage){
		this.name = name;
		this.damage = damage;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getDamage(){
		return damage;
	}
	public void setDamage(String damage){
		this.damage = damage;
	}
	
	public void followHeroShip(){
		System.out.println(getName()+ " is following hero" );
	}
	public void displayEnemyShip(){
		System.out.println(getName()+" is on Screen");
	}
	public void enemyShipShoots(){
		System.out.println(getName()+" attack and dose "+getDamage());
	}
}
