package kounettechnologie.kounet.blogservice.services;


import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.dtos.MediaDTO;
import kounettechnologie.kounet.blogservice.entite.Media;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.MediaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;
    private final BlogMapper blogMapper;

    public MediaService(MediaRepository mediaRepository, BlogMapper blogMapper) {
        this.mediaRepository = mediaRepository;
        this.blogMapper = blogMapper;
    }

    public List<MediaDTO> getAllMedia() {
        List <Media> mediaList = mediaRepository.findAll();
        return mediaList.stream().map(blogMapper::toMediaDTO).collect(Collectors.toList());
    }

    public MediaDTO getMediaById(Long id) throws ResourceNotFoundException {
        Media media = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media not found"));
        return blogMapper.toMediaDTO(media);
    }

    public MediaDTO createMedia(MediaDTO mediaDTO) {
        Media media = blogMapper.toMediaEntity(mediaDTO);
        media = mediaRepository.save(media);
        return blogMapper.toMediaDTO(media);
    }

    public MediaDTO updateMedia(Long id, MediaDTO mediaDTO) throws ResourceNotFoundException {
        Media media = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media not found"));
        media.setDescription(mediaDTO.getDescription());
        media.setType(mediaDTO.getType());
        media.setUrl(mediaDTO.getUrl());
        media = mediaRepository.save(media);
        return blogMapper.toMediaDTO(media);
    }

    public void deleteMedia(Long id) throws ResourceNotFoundException {
        Media media = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media not found"));
        mediaRepository.delete(media);
    }
}
