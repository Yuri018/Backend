package de.ait.mvcdemo2.repository.impl;

import de.ait.mvcdemo2.model.Event;
import de.ait.mvcdemo2.repository.EventRepository;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepositoryFileImpl implements EventRepository {

    private final String fileName;

    public EventRepositoryFileImpl(@Value("${event.file-name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(event.getName() + "," + event.getDescription() + "," + event.getDate());
            writer.newLine();
            writer.flush();
        } catch (IOException e){
            throw new IllegalStateException("Problem with file " + e.getMessage());
        }

    }

    @Override
    public void delete(Event model) {

    }

    @Override
    public void update(Event model) {

    }

    @Override
    public List<Event> findAll() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split(","))
                    .map(parsed -> new Event (parsed[0], parsed[1], LocalDate.parse((parsed[2]))))
                    .collect(Collectors.toList());

        } catch (IOException e){
            throw new IllegalStateException("Problem with file.");
        }
    }

    @Override
    public Event findByDescription(String description) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split(","))
                    .filter(parsed -> parsed[1].contains(description))
                    .findFirst()
                    .map(parsed -> new Event(parsed[0], parsed[1], LocalDate.parse(parsed[2])))
                    .orElse(null);

        } catch (IOException e) {
            throw  new IllegalStateException("Problem with file.");
        }
    }
}
