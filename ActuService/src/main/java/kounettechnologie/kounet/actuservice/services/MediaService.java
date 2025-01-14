package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.MediaDTO;
import kounettechnologie.kounet.actuservice.dtos.MediaDTOResquest;
import kounettechnologie.kounet.actuservice.entity.Media;
import kounettechnologie.kounet.actuservice.mappers.MediaMapper;
import kounettechnologie.kounet.actuservice.repos.MediaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MediaMapper mediaMapper;

    public MediaDTO createMedia(MediaDTOResquest mediaDTORequest) {
        Media media = mediaMapper.fromMediaDTORequest(mediaDTORequest);
        Media savedMedia = mediaRepository.save(media);
        return mediaMapper.toMediaDTO(savedMedia);
    }

    public MediaDTO updateMedia(Long id, MediaDTOResquest mediaDTORequest) {
        Media existingMedia = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
        modelMapper.map(mediaDTORequest, existingMedia); // Met à jour les champs
        Media updatedMedia = mediaRepository.save(existingMedia);
        return mediaMapper.toMediaDTO(updatedMedia);
    }

    public void deleteMedia(Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
        mediaRepository.delete(media);
    }

    public MediaDTO getMediaById(Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
        return mediaMapper.toMediaDTO(media);
    }

    public List<MediaDTO> getAllMedia() {
        List<Media> mediaList = mediaRepository.findAll();
        return mediaList.stream()
                .map(mediaMapper::toMediaDTO)
                .collect(Collectors.toList());
    }
}
