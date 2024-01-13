package de.ait.app2;

import de.ait.app2.controllers.EventController;
import de.ait.app2.repositories.EventRepository;
import de.ait.app2.repositories.impl.EventRepositoryListImpl;
import de.ait.app2.services.impl.EventServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EventRepository eventRepository = new EventRepositoryListImpl();
        EventServiceImpl eventService = new EventServiceImpl(eventRepository);
        EventController eventController = new EventController(scanner, eventService);

        boolean isRun = true;

        while (isRun) {
            System.out.println("Input command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add Event" -> eventController.addEvent();
                case "all Events" -> eventController.getAllEvents();
                case "exit" -> isRun = false;
            }
        }
    }
}
