package de.htwg.seapal.common.observer;

import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public interface IObservable {

	 void addObserver(IObserver s);
	 void removeObserver(IObserver s);
	 void removeAllObservers();
	 void notifyObservers();
	 void notifyObservers(Event e);
}
