package kounettechnologie.kounet.offresspecialesservice.web;

import kounettechnologie.kounet.offresspecialesservice.dto.OffreSpecialeDTO;
import kounettechnologie.kounet.offresspecialesservice.service.OffreSpecialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres-speciales")
public class OffreSpecialeController {

    @Autowired
    private OffreSpecialeService offreSpecialeService;

    @PostMapping
    public ResponseEntity<OffreSpecialeDTO> createOffreSpeciale(@RequestBody OffreSpecialeDTO offreSpecialeDTO) {
        return ResponseEntity.ok(offreSpecialeService.createOffreSpeciale(offreSpecialeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreSpecialeDTO> getOffreSpecialeById(@PathVariable Long id) {
        return ResponseEntity.ok(offreSpecialeService.getOffreSpecialeById(id));
    }

    @GetMapping
    public ResponseEntity<List<OffreSpecialeDTO>> getAllOffresSpeciales() {
        return ResponseEntity.ok(offreSpecialeService.getAllOffresSpeciales());
    }

    @GetMapping("/actives")
    public ResponseEntity<List<OffreSpecialeDTO>> getActiveOffresSpeciales() {
        return ResponseEntity.ok(offreSpecialeService.getActiveOffresSpeciales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OffreSpecialeDTO> updateOffreSpeciale(@PathVariable Long id, @RequestBody OffreSpecialeDTO offreSpecialeDTO) {
        return ResponseEntity.ok(offreSpecialeService.updateOffreSpeciale(id, offreSpecialeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffreSpeciale(@PathVariable Long id) {
        offreSpecialeService.deleteOffreSpeciale(id);
        return ResponseEntity.noContent().build();
    }
}
