package event.service;

import event.entity.Event;

public interface EventService {
	/**
	 * 新增event
	 * @param event
	 */
	void newEvent(Event event);
	/**
	 * 持续event
	 * @param event
	 */
	void updateEvent(Event event);
	/**
	 * 结束event
	 * @param event
	 */
	void endEvent(Event event);
}
