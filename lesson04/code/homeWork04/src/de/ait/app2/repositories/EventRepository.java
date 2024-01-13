package de.ait.app2.repositories;

import de.ait.app2.models.Event;

import java.time.LocalDate;

public interface EventRepository extends CrudRepository<Event>{
    Event findByDate(LocalDate date);
}
