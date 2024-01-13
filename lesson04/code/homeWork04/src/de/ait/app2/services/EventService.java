package de.ait.app2.services;

import de.ait.app2.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    Event addEvent(String description, LocalDate date);

    List<Event> getAllEvents();
}
