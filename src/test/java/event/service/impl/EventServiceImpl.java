package event.service.impl;

import event.entity.Event;
import event.service.EventService;

public class EventServiceImpl implements EventService {

	@Override
	public void newEvent(Event event) {
		System.out.println("收到新增事件:"+event.getEventName());
	}

	@Override
	public void updateEvent(Event event) {
		System.out.println("收到持续事件:"+event.getEventName());
	}

	@Override
	public void endEvent(Event event) {
		System.out.println("收到结束事件:"+event.getEventName());
	}

}
