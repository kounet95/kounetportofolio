package kounettechnologie.kounet.actuservice.mappers;


import kounettechnologie.kounet.actuservice.dtos.EventDTO;
import kounettechnologie.kounet.actuservice.dtos.EventDTORequest;
import kounettechnologie.kounet.actuservice.entity.Event;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Convertit un EventDTORequest en entité Event.
     */
    public Event fromEventDTORequest(EventDTORequest eventDTORequest) {
        return modelMapper.map(eventDTORequest, Event.class);
    }

    /**
     * Convertit une entité Event en EventDTO.
     */
    public EventDTO toEventDTO(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    /**
     * Convertit une entité Event en EventDTORequest.
     */
    public EventDTORequest toEventDTORequest(Event event) {
        return modelMapper.map(event, EventDTORequest.class);
    }

    /**
     * Convertit un EventDTO en entité Event.
     */
    public Event fromEventDTO(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }
}
