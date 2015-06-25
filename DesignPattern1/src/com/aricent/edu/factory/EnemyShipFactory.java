package com.aricent.edu.factory;

public class EnemyShipFactory {

		public EnemyShip makeEnemyShip(String enemyShipType){
			EnemyShip enemyShip = null;
			if(enemyShipType.equalsIgnoreCase("U")){
				enemyShip = new UFOEnemyShip();
				return enemyShip;
			}else if(enemyShipType.equalsIgnoreCase("R")){
				enemyShip = new RocketEnemyShip();
				return enemyShip;
			}else if(enemyShipType.equalsIgnoreCase("B")){
				enemyShip = new BigUFOEnemyShip();
				return enemyShip;
			}else return null;
		}
}
