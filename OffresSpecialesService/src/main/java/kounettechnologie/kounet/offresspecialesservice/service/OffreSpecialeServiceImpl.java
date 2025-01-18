package kounettechnologie.kounet.offresspecialesservice.service;

import kounettechnologie.kounet.offresspecialesservice.dto.OffreSpecialeDTO;
import kounettechnologie.kounet.offresspecialesservice.entity.OffreSpeciale;
import kounettechnologie.kounet.offresspecialesservice.mapper.OffreSpecialeMapper;
import kounettechnologie.kounet.offresspecialesservice.repos.OffreSpecialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffreSpecialeServiceImpl implements OffreSpecialeService {

    @Autowired
    private OffreSpecialeRepository offreSpecialeRepository;

    @Autowired
    private OffreSpecialeMapper offreSpecialeMapper;

    @Override
    public OffreSpecialeDTO createOffreSpeciale(OffreSpecialeDTO offreSpecialeDTO) {
        OffreSpeciale offreSpeciale = offreSpecialeMapper.fromOffreSpecialeDTO(offreSpecialeDTO);
        OffreSpeciale savedOffreSpeciale = offreSpecialeRepository.save(offreSpeciale);
        return offreSpecialeMapper.toOffreSpecialeDTO(savedOffreSpeciale);
    }

    @Override
    public OffreSpecialeDTO getOffreSpecialeById(Long id) {
        OffreSpeciale offreSpeciale = offreSpecialeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre spéciale non trouvée avec l'ID : " + id));
        return offreSpecialeMapper.toOffreSpecialeDTO(offreSpeciale);
    }

    @Override
    public List<OffreSpecialeDTO> getAllOffresSpeciales() {
        return offreSpecialeRepository.findAll().stream()
                .map(offreSpecialeMapper::toOffreSpecialeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OffreSpecialeDTO> getActiveOffresSpeciales() {
        LocalDate now = LocalDate.now();
        return offreSpecialeRepository.findByStartDateBeforeAndEndDateAfter(now, now).stream()
                .map(offreSpecialeMapper::toOffreSpecialeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OffreSpecialeDTO updateOffreSpeciale(Long id, OffreSpecialeDTO offreSpecialeDTO) {
        OffreSpeciale existingOffre = offreSpecialeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre spéciale non trouvée avec l'ID : " + id));

        existingOffre.setTitle(offreSpecialeDTO.getTitle());
        existingOffre.setDescription(offreSpecialeDTO.getDescription());
        existingOffre.setDiscountPercentage(offreSpecialeDTO.getDiscountPercentage());
        existingOffre.setStartDate(offreSpecialeDTO.getStartDate());
        existingOffre.setEndDate(offreSpecialeDTO.getEndDate());

        OffreSpeciale updatedOffre = offreSpecialeRepository.save(existingOffre);
        return offreSpecialeMapper.toOffreSpecialeDTO(updatedOffre);
    }

    @Override
    public void deleteOffreSpeciale(Long id) {
        if (!offreSpecialeRepository.existsById(id)) {
            throw new RuntimeException("Offre spéciale non trouvée avec l'ID : " + id);
        }
        offreSpecialeRepository.deleteById(id);
    }
}

