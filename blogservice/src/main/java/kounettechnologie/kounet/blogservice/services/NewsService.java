package kounettechnologie.kounet.blogservice.services;


import kounettechnologie.kounet.blogservice.Mapper.BlogMapper;
import kounettechnologie.kounet.blogservice.dtos.NewsDTO;
import kounettechnologie.kounet.blogservice.dtos.NewsDTORequest;
import kounettechnologie.kounet.blogservice.entite.News;
import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.repos.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final BlogMapper blogMapper;

    public NewsService(NewsRepository newsRepository, BlogMapper blogMapper) {
        this.newsRepository = newsRepository;
        this.blogMapper = blogMapper;
    }

    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream().map(blogMapper::toNewsDTO).collect(Collectors.toList());
    }

    public NewsDTO getNewsById(Long id) throws ResourceNotFoundException {
        News news = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("News not found"));
        return blogMapper.toNewsDTO(news);
    }

    public NewsDTO createNews(NewsDTORequest newsDTOResquest) {
        News news = blogMapper.toNewsEntity(newsDTOResquest);
        news = newsRepository.save(news);
        return blogMapper.toNewsDTO(news);
    }

    public NewsDTO updateNews(Long id, NewsDTORequest newsDTORequest) throws ResourceNotFoundException {
        News news = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("News not found"));
        news.setContent(newsDTORequest.getContent());
        news.setTitle(newsDTORequest.getTitle());
        // Update other fields as necessary
        news = newsRepository.save(news);
        return blogMapper.toNewsDTO(news);
    }

    public void deleteNews(Long id) throws ResourceNotFoundException {
        News news = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("News not found"));
        newsRepository.delete(news);
    }
}
