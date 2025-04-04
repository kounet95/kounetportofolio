package kounettechnologie.kounet.blogservice.services;


import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.dtos.TagDTO;
import kounettechnologie.kounet.blogservice.dtos.TagDTORequest;
import kounettechnologie.kounet.blogservice.entite.Tag;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final BlogMapper blogMapper;

    public TagService(TagRepository tagRepository, BlogMapper blogMapper) {
        this.tagRepository = tagRepository;
        this.blogMapper = blogMapper;
    }

    public List<TagDTO> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(blogMapper::toTagDTO).collect(Collectors.toList());
    }

    public TagDTO getTagById(Long id) throws ResourceNotFoundException {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        return blogMapper.toTagDTO(tag);
    }

    public TagDTO createTag(TagDTORequest tagDTORequest) {
        Tag tag = blogMapper.toTagEntity(tagDTORequest);
        tag = tagRepository.save(tag);
        return blogMapper.toTagDTO(tag);
    }

    public TagDTO updateTag(Long id, TagDTORequest tagDTORequest) throws ResourceNotFoundException {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        tag.setName(tagDTORequest.getName());
        // Update other fields as necessary
        tag = tagRepository.save(tag);
        return blogMapper.toTagDTO(tag);
    }

    public void deleteTag(Long id)throws ResourceNotFoundException {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag not found"));
        tagRepository.delete(tag);
    }
}
