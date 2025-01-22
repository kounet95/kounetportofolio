package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.EventDTO;
import kounettechnologie.kounet.actuservice.dtos.EventDTORequest;
import kounettechnologie.kounet.actuservice.entity.Event;
import kounettechnologie.kounet.actuservice.mappers.EventMapper;
import kounettechnologie.kounet.actuservice.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private ItemRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    /**
     * Crée un nouvel événement.
     * @param eventDTORequest Les données pour créer l'événement.
     * @return L'événement créé sous forme de DTO.
     */
    public EventDTO createEvent(EventDTORequest eventDTORequest) {
        Event event = eventMapper.fromEventDTORequest(eventDTORequest);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toEventDTO(savedEvent);
    }

    /**
     * Met à jour un événement existant.
     * @param id L'identifiant de l'événement à mettre à jour.
     * @param eventDTORequest Les nouvelles données de l'événement.
     * @return L'événement mis à jour sous forme de DTO.
     */
    public EventDTO updateEvent(Long id, EventDTORequest eventDTORequest) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        existingEvent.setDescription(eventDTORequest.getDescription());
        existingEvent.setStartDate(eventDTORequest.getStartDate());
        existingEvent.setEndDate(eventDTORequest.getEndDate());
        existingEvent.setLocation(eventDTORequest.getLocation());
        existingEvent.setIsOnline(eventDTORequest.getIsOnline());
        existingEvent.setRegistrationLink(eventDTORequest.getRegistrationLink());
        existingEvent.setTags(eventDTORequest.getTags());
        existingEvent.setMediaUrls(eventDTORequest.getMediaUrls());

        Event updatedEvent = eventRepository.save(existingEvent);
        return eventMapper.toEventDTO(updatedEvent);
    }

    /**
     * Supprime un événement par ID.
     * @param id L'identifiant de l'événement à supprimer.
     */
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        eventRepository.delete(event);
    }

    /**
     * Récupère un événement par ID.
     * @param id L'identifiant de l'événement à récupérer.
     * @return L'événement sous forme de DTO.
     */
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return eventMapper.toEventDTO(event);
    }

    /**
     * Récupère tous les événements.
     * @return Une liste de tous les événements sous forme de DTO.
     */
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(eventMapper::toEventDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recherche les événements en ligne.
     * @return Une liste des événements en ligne sous forme de DTO.
     */
    public List<EventDTO> getOnlineEvents() {
        List<Event> onlineEvents = eventRepository.findByIsOnlineTrue();
        return onlineEvents.stream()
                .map(eventMapper::toEventDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recherche les événements par mot-clé dans le nom ou la description.
     * @param keyword Le mot-clé à rechercher.
     * @return Une liste des événements correspondants sous forme de DTO.
     */
    public List<EventDTO> searchEventsByKeyword(String keyword) {
        List<Event> events = eventRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
        return events.stream()
                .map(eventMapper::toEventDTO)
                .collect(Collectors.toList());
    }
}
