package kounettechnologie.kounet.actuservice.mappers;

import kounettechnologie.kounet.actuservice.dtos.TagDTO;
import kounettechnologie.kounet.actuservice.dtos.TagDTORequest;
import kounettechnologie.kounet.actuservice.entity.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Convertit un TagDTORequest en entité Tag.
     */
    public Tag fromTagDTORequest(TagDTORequest tagDTORequest) {
        return modelMapper.map(tagDTORequest, Tag.class);
    }

    /**
     * Convertit une entité Tag en TagDTORequest.
     */
    public TagDTORequest toTagDTORequest(Tag tag) {
        return modelMapper.map(tag, TagDTORequest.class);
    }

    /**
     * Convertit une entité Tag en TagDTO.
     */
    public TagDTO toTagDTO(Tag tag) {
        return modelMapper.map(tag, TagDTO.class);
    }

    /**
     * Convertit un TagDTO en entité Tag.
     */
    public Tag fromTagDTO(TagDTO tagDTO) {
        return modelMapper.map(tagDTO, Tag.class);
    }
}

