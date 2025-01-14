package kounettechnologie.kounet.actuservice.mappers;

import kounettechnologie.kounet.actuservice.dtos.MediaDTO;
import kounettechnologie.kounet.actuservice.entity.Media;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import  kounettechnologie.kounet.actuservice.dtos.MediaDTOResquest;

@Component
public class MediaMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Convertit un MediaDTO en entité Media.
     */
    public Media fromMediaDTO(MediaDTO mediaDTO) {
        return modelMapper.map(mediaDTO, Media.class);
    }

    /**
     * Convertit une entité Media en MediaDTO.
     */
    public MediaDTO toMediaDTO(Media media) {
        return modelMapper.map(media, MediaDTO.class);
    }
    /**
     * Convertit un MediaDTORequest en entité Media.
     */
    public Media fromMediaDTORequest(MediaDTOResquest mediaDTORequest) {
        return modelMapper.map(mediaDTORequest, Media.class);
    }

    /**
     * Convertit une entité Media en MediaDTORequest.
     */
    public MediaDTOResquest toMediaDTORequest(Media media) {
        return modelMapper.map(media, MediaDTOResquest.class);
    }
}

