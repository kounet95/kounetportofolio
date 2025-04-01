package kounettechnologie.kounet.coursservice.service;


import kounettechnologie.kounet.coursservice.dto.CoursDTO;

import java.util.List;

public interface CoursService {
    CoursDTO createCours(CoursDTO coursDTO);
    CoursDTO getCoursById(Long id);
    List<CoursDTO> getAllCours();
    CoursDTO updateCours(Long id, CoursDTO coursDTO);
    void deleteCours(Long id);
}
