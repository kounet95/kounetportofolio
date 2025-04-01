package kounettechnologie.kounet.coursservice.mapper;




import kounettechnologie.kounet.coursservice.dto.CoursDTO;
import kounettechnologie.kounet.coursservice.entity.Cours;
import org.springframework.stereotype.Component;

@Component
public class CoursMapper {

    public CoursDTO toCoursDTO(Cours cours) {
        return new CoursDTO(
                cours.getId(),
                cours.getTitle(),
                cours.getDescription(),
                cours.getPrice(),
                cours.getInstructorName()
        );
    }

    public Cours fromCoursDTO(CoursDTO coursDTO) {
        Cours cours = new Cours();
        cours.setId(coursDTO.getId());
        cours.setTitle(coursDTO.getTitle());
        cours.setDescription(coursDTO.getDescription());
        cours.setPrice(coursDTO.getPrice());
        cours.setInstructorName(coursDTO.getInstructorName());
        return cours;
    }
}

