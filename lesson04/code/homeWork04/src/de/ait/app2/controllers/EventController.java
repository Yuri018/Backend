package de.ait.app2.controllers;

import de.ait.app2.models.Event;
import de.ait.app2.services.impl.EventServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EventController {

    private final Scanner scanner;
    private final EventServiceImpl eventService;

    public EventController(Scanner scanner, EventServiceImpl eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }

    public void addEvent() {
        System.out.println("Enter event description: ");
        String description = scanner.nextLine();

        System.out.println("Enter the date in the format yyyy-MM-dd: ");
        String enterDate = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(enterDate, formatter);
            Event event = eventService.addEvent(description, date);
            System.out.println(event);
        } catch (Exception e) {
            System.out.println("Incorrect date input format. Input format: year-month-day");
        }
    }

    public void getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        System.out.println(events);
    }
}
