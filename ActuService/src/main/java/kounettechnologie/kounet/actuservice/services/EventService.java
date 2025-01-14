package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.EventDTO;
import kounettechnologie.kounet.actuservice.dtos.EventDTORequest;
import kounettechnologie.kounet.actuservice.entity.Event;
import kounettechnologie.kounet.actuservice.mappers.EventMapper;
import kounettechnologie.kounet.actuservice.repos.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private EventMapper eventMapper;

    public EventDTO createEvent(EventDTORequest eventDTORequest) {
        Event event = eventMapper.fromEventDTORequest(eventDTORequest);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toEventDTO(savedEvent);
    }

    public EventDTO updateEvent(Long id, EventDTORequest eventDTORequest) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        modelMapper.map(eventDTORequest, existingEvent); // Met à jour les champs
        Event updatedEvent = eventRepository.save(existingEvent);
        return eventMapper.toEventDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        eventRepository.delete(event);
    }

    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return eventMapper.toEventDTO(event);
    }

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(eventMapper::toEventDTO)
                .collect(Collectors.toList());
    }
}
