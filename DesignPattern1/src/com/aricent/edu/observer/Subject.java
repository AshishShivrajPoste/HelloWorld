package com.aricent.edu.observer;

import java.util.Observable;

public interface Subject {

		public void register(Observer o);
		public void unregister(Observer o);
		public void notifyObservers();
}
