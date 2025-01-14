package kounettechnologie.kounet.actuservice.services;



import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTO;
import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTORequest;
import kounettechnologie.kounet.actuservice.entity.Announcement;

import kounettechnologie.kounet.actuservice.mappers.AnnouncementMapper;
import kounettechnologie.kounet.actuservice.repos.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private AnnouncementMapper announcementMapper;

    /**
     * Crée une nouvelle annonce.
     */
    public AnnouncementDTO createAnnouncement(AnnouncementDTORequest announcementDTORequest) {
        Announcement announcement = announcementMapper.fromAnnouncementDTORequest(announcementDTORequest);
        Announcement savedAnnouncement = announcementRepository.save(announcement);
        return announcementMapper.toAnnouncementDTO(savedAnnouncement);
    }

    /**
     * Met à jour une annonce existante.
     */
    public AnnouncementDTO updateAnnouncement(Long id, AnnouncementDTORequest announcementDTORequest) {
        Announcement existingAnnouncement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        existingAnnouncement.setMessage(announcementDTORequest.getMessage());
        existingAnnouncement.setAnnouncementDate(announcementDTORequest.getAnnouncementDate());
        existingAnnouncement.setIsHighlighted(announcementDTORequest.getIsHighlighted());
        existingAnnouncement.setTag(announcementDTORequest.getTag());
        Announcement updatedAnnouncement = announcementRepository.save(existingAnnouncement);
        return announcementMapper.toAnnouncementDTO(updatedAnnouncement);
    }

    /**
     * Supprime une annonce par ID.
     */
    public void deleteAnnouncement(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        announcementRepository.delete(announcement);
    }

    /**
     * Récupère une annonce par ID.
     */
    public AnnouncementDTO getAnnouncementById(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        return announcementMapper.toAnnouncementDTO(announcement);
    }

    /**
     * Récupère toutes les annonces.
     */
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
                .map(announcementMapper::toAnnouncementDTO)
                .collect(Collectors.toList());
    }
}
