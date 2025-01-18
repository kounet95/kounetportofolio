package kounettechnologie.kounet.category.mapper;



import kounettechnologie.kounet.category.dto.MescategoriesDTO;
import kounettechnologie.kounet.category.entity.Mescategories;

import java.util.List;
import java.util.stream.Collectors;

public class MescategoriesMapper {

    public static MescategoriesDTO toDTO(Mescategories category) {
        if (category == null) {
            return null;
        }

        MescategoriesDTO categoryDTO = new MescategoriesDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());

        return categoryDTO;
    }

    public static Mescategories toEntity(MescategoriesDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Mescategories category = new Mescategories();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        return category;
    }

    public static List<MescategoriesDTO> toDTOList(List<Mescategories> categories) {
        return categories.stream()
                .map(MescategoriesMapper::toDTO)
                .collect(Collectors.toList());
    }
}
