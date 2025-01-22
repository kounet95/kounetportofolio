package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTO;
import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTORequest;
import kounettechnologie.kounet.actuservice.entity.Announcement;
import kounettechnologie.kounet.actuservice.mappers.AnnouncementMapper;
import kounettechnologie.kounet.actuservice.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AnnouncementMapper announcementMapper;

    /**
     * Crée une nouvelle annonce.
     * @param announcementDTORequest Les données pour créer une annonce.
     * @return L'annonce créée sous forme de DTO.
     */
    public AnnouncementDTO createAnnouncement(AnnouncementDTORequest announcementDTORequest) {
        Announcement announcement = announcementMapper.fromAnnouncementDTORequest(announcementDTORequest);
        Announcement savedAnnouncement = itemRepository.save(announcement);
        return announcementMapper.toAnnouncementDTO(savedAnnouncement);
    }

    /**
     * Met à jour une annonce existante.
     * @param id L'identifiant de l'annonce à mettre à jour.
     * @param announcementDTORequest Les nouvelles données de l'annonce.
     * @return L'annonce mise à jour sous forme de DTO.
     */
    public AnnouncementDTO updateAnnouncement(Long id, AnnouncementDTORequest announcementDTORequest) {
        Announcement existingAnnouncement = (Announcement) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        existingAnnouncement.setMessage(announcementDTORequest.getMessage());
        existingAnnouncement.setIsHighlighted(announcementDTORequest.getIsHighlighted());
        Announcement updatedAnnouncement = itemRepository.save(existingAnnouncement);
        return announcementMapper.toAnnouncementDTO(updatedAnnouncement);
    }

    /**
     * Supprime une annonce par ID.
     * @param id L'identifiant de l'annonce à supprimer.
     */
    public void deleteAnnouncement(Long id) {
        Announcement announcement = (Announcement) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        itemRepository.delete(announcement);
    }

    /**
     * Récupère une annonce par ID.
     * @param id L'identifiant de l'annonce à récupérer.
     * @return L'annonce sous forme de DTO.
     */
    public AnnouncementDTO getAnnouncementById(Long id) {
        Announcement announcement = (Announcement) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id: " + id));
        return announcementMapper.toAnnouncementDTO(announcement);
    }

    /**
     * Récupère toutes les annonces.
     * @return Une liste de toutes les annonces sous forme de DTO.
     */
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = itemRepository.findAllAnnouncements().stream()
                .map(item -> (Announcement) item)
                .collect(Collectors.toList());
        return announcements.stream()
                .map(announcementMapper::toAnnouncementDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recherche les annonces mises en avant.
     * @return Une liste des annonces mises en avant sous forme de DTO.
     */
    public List<AnnouncementDTO> getHighlightedAnnouncements() {
        List<Announcement> highlightedAnnouncements = itemRepository.findHighlightedAnnouncements().stream()
                .map(item -> (Announcement) item)
                .collect(Collectors.toList());
        return highlightedAnnouncements.stream()
                .map(announcementMapper::toAnnouncementDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recherche les annonces contenant un mot-clé spécifique dans leur message.
     * @param keyword Le mot-clé à rechercher.
     * @return Une liste des annonces correspondantes sous forme de DTO.
     */
    public List<AnnouncementDTO> searchAnnouncementsByKeyword(String keyword) {
        List<Announcement> announcements = itemRepository.searchAnnouncementsByKeyword(keyword).stream()
                .map(item -> (Announcement) item)
                .collect(Collectors.toList());
        return announcements.stream()
                .map(announcementMapper::toAnnouncementDTO)
                .collect(Collectors.toList());
    }
}
