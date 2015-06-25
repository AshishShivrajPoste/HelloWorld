package com.aricent.edu.factory;

import java.util.Scanner;

public class EnemyShipTesting {

		public static void main(String[] args) {
			EnemyShipFactory enemyShipFactory = new EnemyShipFactory();
			EnemyShip theEnemyShip = null;
			Scanner userInput = new Scanner(System.in);
			System.out.println("What type of ship?(U / R / B)");
			if(userInput.hasNext()){
				String typeofShip = userInput.nextLine();
				theEnemyShip = enemyShipFactory.makeEnemyShip(typeofShip);
			}
			if(theEnemyShip != null){
				doSomeStuff(theEnemyShip);
			}else {
				System.out.println("Choice Proper Enemy Ship");
			}
		}
		public static void doSomeStuff(EnemyShip enemyShip){
			enemyShip.followHeroShip();
			enemyShip.displayEnemyShip();
			enemyShip.enemyShipShoots();
		}
}
