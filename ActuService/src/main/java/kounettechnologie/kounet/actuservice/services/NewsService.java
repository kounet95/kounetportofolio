package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.NewsDTO;
import kounettechnologie.kounet.actuservice.dtos.NewsDTOResquest;
import kounettechnologie.kounet.actuservice.entity.News;
import kounettechnologie.kounet.actuservice.mappers.NewsMapper;
import kounettechnologie.kounet.actuservice.repos.NewsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsMapper newsMapper;

    private final ModelMapper modelMapper = new ModelMapper();
    public NewsDTO createNews(NewsDTOResquest newsDTORequest) {
        News news = newsMapper.fromNewsDTORequest(newsDTORequest);
        News savedNews = newsRepository.save(news);
        return newsMapper.toNewsDTO(savedNews);
    }

    public NewsDTO updateNews(Long id, NewsDTOResquest newsDTORequest) {
        News existingNews = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        modelMapper.map(newsDTORequest, existingNews); // Met à jour les champs
        News updatedNews = newsRepository.save(existingNews);
        return newsMapper.toNewsDTO(updatedNews);
    }

    public void deleteNews(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        newsRepository.delete(news);
    }

    public NewsDTO getNewsById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        return newsMapper.toNewsDTO(news);
    }

    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream()
                .map(newsMapper::toNewsDTO)
                .collect(Collectors.toList());
    }
}
