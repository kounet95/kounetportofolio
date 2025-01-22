package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.TagDTO;
import kounettechnologie.kounet.actuservice.dtos.TagDTORequest;
import kounettechnologie.kounet.actuservice.entity.Tag;
import kounettechnologie.kounet.actuservice.mappers.TagMapper;
import kounettechnologie.kounet.actuservice.repos.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    public TagDTO createTag(TagDTORequest tagDTORequest) {
        Tag tag = tagMapper.fromTagDTORequest(tagDTORequest);
        Tag savedTag = tagRepository.save(tag);
        return tagMapper.toTagDTO(savedTag);
    }

    public TagDTO updateTag(Long id, TagDTORequest tagDTORequest) {
        Tag existingTag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + id));

        existingTag.setKeys(tagDTORequest.getKeys());

        Tag updatedTag = tagRepository.save(existingTag);
        return tagMapper.toTagDTO(updatedTag);
    }

    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + id));
        tagRepository.delete(tag);
    }

    public TagDTO getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id: " + id));
        return tagMapper.toTagDTO(tag);
    }

    public List<TagDTO> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream()
                .map(tagMapper::toTagDTO)
                .collect(Collectors.toList());
    }
}
