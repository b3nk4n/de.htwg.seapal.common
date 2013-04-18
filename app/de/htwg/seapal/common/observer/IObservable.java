package de.htwg.seapal.common.observer;

import de.htwg.seapal.common.observer.Event;
import de.htwg.seapal.common.observer.IObserver;

public interface IObservable {

	/**
	 * Adds an observer.
	 * @param observer The observer to add.
	 */
	void addObserver(IObserver observer);

	/**
	 * Removes an observer.
	 * @param observer The observer to remove.
	 */
	void removeObserver(IObserver observer);

	/**
	 * Removes all observers.
	 */
	void removeAllObservers();

	/**
	 * Notifies all observers.
	 */
	void notifyObservers();

	/**
	 * Notifies all oberservers.
	 * @param event The notify event.
	 */
	void notifyObservers(Event event);
}
