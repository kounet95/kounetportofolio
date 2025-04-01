package kounettechnologie.kounet.coursservice.service;


import kounettechnologie.kounet.coursservice.dto.CoursDTO;
import kounettechnologie.kounet.coursservice.entity.Cours;
import kounettechnologie.kounet.coursservice.mapper.CoursMapper;
import kounettechnologie.kounet.coursservice.repos.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private CoursMapper coursMapper;

    @Override
    public CoursDTO createCours(CoursDTO coursDTO) {
        Cours cours = coursMapper.fromCoursDTO(coursDTO);
        Cours savedCours = coursRepository.save(cours);
        return coursMapper.toCoursDTO(savedCours);
    }

    @Override
    public CoursDTO getCoursById(Long id) {
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours not found with id: " + id));
        return coursMapper.toCoursDTO(cours);
    }

    @Override
    public List<CoursDTO> getAllCours() {
        return coursRepository.findAll().stream()
                .map(coursMapper::toCoursDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CoursDTO updateCours(Long id, CoursDTO coursDTO) {
        Cours existingCours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours not found with id: " + id));

        existingCours.setTitle(coursDTO.getTitle());
        existingCours.setDescription(coursDTO.getDescription());
        existingCours.setPrice(coursDTO.getPrice());
        existingCours.setInstructorName(coursDTO.getInstructorName());

        Cours updatedCours = coursRepository.save(existingCours);
        return coursMapper.toCoursDTO(updatedCours);
    }

    @Override
    public void deleteCours(Long id) {
        if (!coursRepository.existsById(id)) {
            throw new RuntimeException("Cours not found with id: " + id);
        }
        coursRepository.deleteById(id);
    }
}

