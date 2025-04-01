package kounettechnologie.kounet.offresspecialesservice.mapper;


import kounettechnologie.kounet.offresspecialesservice.dto.OffreSpecialeDTO;
import kounettechnologie.kounet.offresspecialesservice.entity.OffreSpeciale;
import org.springframework.stereotype.Component;

@Component
public class OffreSpecialeMapper {

    public OffreSpecialeDTO toOffreSpecialeDTO(OffreSpeciale offreSpeciale) {
        return new OffreSpecialeDTO(
                offreSpeciale.getId(),
                offreSpeciale.getTitle(),
                offreSpeciale.getDescription(),
                offreSpeciale.getDiscountPercentage(),
                offreSpeciale.getStartDate(),
                offreSpeciale.getEndDate()
        );
    }

    public OffreSpeciale fromOffreSpecialeDTO(OffreSpecialeDTO offreSpecialeDTO) {
        OffreSpeciale offreSpeciale = new OffreSpeciale();
        offreSpeciale.setId(offreSpecialeDTO.getId());
        offreSpeciale.setTitle(offreSpecialeDTO.getTitle());
        offreSpeciale.setDescription(offreSpecialeDTO.getDescription());
        offreSpeciale.setDiscountPercentage(offreSpecialeDTO.getDiscountPercentage());
        offreSpeciale.setStartDate(offreSpecialeDTO.getStartDate());
        offreSpeciale.setEndDate(offreSpecialeDTO.getEndDate());
        return offreSpeciale;
    }
}

