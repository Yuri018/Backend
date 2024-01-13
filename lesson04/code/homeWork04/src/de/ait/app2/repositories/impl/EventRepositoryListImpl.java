package de.ait.app2.repositories.impl;

import de.ait.app2.models.Event;
import de.ait.app2.repositories.EventRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryListImpl implements EventRepository {

    private final List<Event> events = new ArrayList<>();
    private Long generatedId = 1L;
    @Override
    public void save(Event event) {
        events.add(event);
        event.setId(generatedId);
        generatedId++;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Event findByDate(LocalDate date) {
        return events.stream()
                .filter(event -> event.getDate().equals(date))
                .findFirst()
                .orElse(null);
    }
}
