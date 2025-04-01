package kounettechnologie.kounet.blogservice.services;

import kounettechnologie.kounet.blogservice.dtos.EventDTO;
import kounettechnologie.kounet.blogservice.dtos.EventDTORequest;
import kounettechnologie.kounet.blogservice.entite.Event;
import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;  // Utilisation du BlogMapper
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final BlogMapper blogMapper;

    public EventService(EventRepository eventRepository, BlogMapper blogMapper) {
        this.eventRepository = eventRepository;
        this.blogMapper = blogMapper;
    }

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(blogMapper::toEventDTO).collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) throws ResourceNotFoundException {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return blogMapper.toEventDTO(event);
    }

    public EventDTO createEvent(EventDTORequest eventDTORequest) {
        Event event = blogMapper.toEventEntity(eventDTORequest);
        event = eventRepository.save(event);
        return blogMapper.toEventDTO(event);
    }

    public EventDTO updateEvent(Long id, EventDTORequest eventDTORequest) throws ResourceNotFoundException {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setName(eventDTORequest.getName());
        event.setLocation(eventDTORequest.getLocation());
        // Update other fields as necessary
        event = eventRepository.save(event);
        return blogMapper.toEventDTO(event);
    }

    public void deleteEvent(Long id) throws ResourceNotFoundException {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        eventRepository.delete(event);
    }
}