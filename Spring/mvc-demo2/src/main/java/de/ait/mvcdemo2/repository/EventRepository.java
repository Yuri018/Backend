package de.ait.mvcdemo2.repository;

import de.ait.mvcdemo2.model.Event;

public interface EventRepository extends CrudRepository<Event>{
    Event findByDescription(String description);
}
