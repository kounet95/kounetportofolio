package kounettechnologie.kounet.coursservice.web;

import kounettechnologie.kounet.coursservice.dto.CoursDTO;
import kounettechnologie.kounet.coursservice.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @PostMapping
    public ResponseEntity<CoursDTO> createCours(@RequestBody CoursDTO coursDTO) {
        CoursDTO createdCours = coursService.createCours(coursDTO);
        return ResponseEntity.ok(createdCours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDTO> getCoursById(@PathVariable Long id) {
        CoursDTO coursDTO = coursService.getCoursById(id);
        return ResponseEntity.ok(coursDTO);
    }

    @GetMapping
    public ResponseEntity<List<CoursDTO>> getAllCours() {
        List<CoursDTO> coursList = coursService.getAllCours();
        return ResponseEntity.ok(coursList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoursDTO> updateCours(@PathVariable Long id, @RequestBody CoursDTO coursDTO) {
        CoursDTO updatedCours = coursService.updateCours(id, coursDTO);
        return ResponseEntity.ok(updatedCours);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
        return ResponseEntity.noContent().build();
    }
}

