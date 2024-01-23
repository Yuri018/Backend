package de.ait.mvcdemo2.service;

import de.ait.mvcdemo2.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event addEvent(String name, String description, LocalDate date);
    List<Event> getAllEvents();
}
