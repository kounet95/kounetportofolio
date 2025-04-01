package kounettechnologie.kounet.offresspecialesservice.service;


import kounettechnologie.kounet.offresspecialesservice.dto.OffreSpecialeDTO;

import java.util.List;

public interface OffreSpecialeService {
    OffreSpecialeDTO createOffreSpeciale(OffreSpecialeDTO offreSpecialeDTO);
    OffreSpecialeDTO getOffreSpecialeById(Long id);
    List<OffreSpecialeDTO> getAllOffresSpeciales();
    List<OffreSpecialeDTO> getActiveOffresSpeciales();
    OffreSpecialeDTO updateOffreSpeciale(Long id, OffreSpecialeDTO offreSpecialeDTO);
    void deleteOffreSpeciale(Long id);
}
