package de.htwg.seapal.common.observer;

import de.htwg.seapal.common.observer.Event;

public interface IObserver {
	/**
	 * Updates the observer.
	 * @param event The update event.
	 */
	void update(Event event);
}
