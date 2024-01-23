package de.ait.mvcdemo2.service.impl;

import de.ait.mvcdemo2.model.Event;
import de.ait.mvcdemo2.repository.EventRepository;
import de.ait.mvcdemo2.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent(String name, String description, LocalDate date) {
        Event event = new Event(name, description, date);
        eventRepository.save(event);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
