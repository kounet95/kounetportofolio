package kounettechnologie.kounet.actuservice.web;

import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTO;
import kounettechnologie.kounet.actuservice.dtos.AnnouncementDTORequest;
import kounettechnologie.kounet.actuservice.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actu/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestBody AnnouncementDTORequest request) {
        AnnouncementDTO createdAnnouncement = announcementService.createAnnouncement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnouncement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementDTORequest request) {
        AnnouncementDTO updatedAnnouncement = announcementService.updateAnnouncement(id, request);
        return ResponseEntity.ok(updatedAnnouncement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable Long id) {
        AnnouncementDTO announcement = announcementService.getAnnouncementById(id);
        return ResponseEntity.ok(announcement);
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getAllAnnouncements() {
        List<AnnouncementDTO> announcements = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }
}
