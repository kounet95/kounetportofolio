package kounettechnologie.kounet.actuservice.mappers;

import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTO;
import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTORequest;
import kounettechnologie.kounet.actuservice.entity.Announcement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AnnouncementMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Convertit un AnnouncementDTORequest en entité Announcement.
     */
    public Announcement fromAnnouncementDTORequest(AnnouncementDTORequest announcementDTORequest) {
        return modelMapper.map(announcementDTORequest, Announcement.class);
    }

    /**
     * Convertit une entité Announcement en AnnouncementDTORequest.
     */
    public AnnouncementDTORequest toAnnouncementDTORequest(Announcement announcement) {
        return modelMapper.map(announcement, AnnouncementDTORequest.class);
    }

    /**
     * Convertit une entité Announcement en AnnouncementDTO.
     */
    public AnnouncementDTO toAnnouncementDTO(Announcement announcement) {
        return modelMapper.map(announcement, AnnouncementDTO.class);
    }

    /**
     * Convertit un AnnouncementDTO en entité Announcement.
     */
    public Announcement fromAnnouncementDTO(AnnouncementDTO announcementDTO) {
        return modelMapper.map(announcementDTO, Announcement.class);
    }
}

