package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.NewsDTO;
import kounettechnologie.kounet.actuservice.entity.News;
import kounettechnologie.kounet.actuservice.mappers.NewsMapper;
import kounettechnologie.kounet.actuservice.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private NewsMapper newsMapper;

    /**
     * Crée une nouvelle actualité.
     * @param newsDTORequest Les données pour créer une actualité.
     * @return L'actualité créée sous forme de DTO.
     */
    public NewsDTO createNews(NewsDTORequest newsDTORequest) {
        News news = newsMapper.fromNewsDTORequest(newsDTORequest);
        News savedNews = itemRepository.save(news);
        return newsMapper.toNewsDTO(savedNews);
    }

    /**
     * Met à jour une actualité existante.
     * @param id L'identifiant de l'actualité à mettre à jour.
     * @param newsDTORequest Les nouvelles données de l'actualité.
     * @return L'actualité mise à jour sous forme de DTO.
     */
    public NewsDTO updateNews(Long id, NewsDTORequest newsDTORequest) {
        News existingNews = (News) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        existingNews.setTitle(newsDTORequest.getTitle());
        existingNews.setContent(newsDTORequest.getContent());
        News updatedNews = itemRepository.save(existingNews);
        return newsMapper.toNewsDTO(updatedNews);
    }

    /**
     * Supprime une actualité par ID.
     * @param id L'identifiant de l'actualité à supprimer.
     */
    public void deleteNews(Long id) {
        News news = (News) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        itemRepository.delete(news);
    }

    /**
     * Récupère une actualité par ID.
     * @param id L'identifiant de l'actualité à récupérer.
     * @return L'actualité sous forme de DTO.
     */
    public NewsDTO getNewsById(Long id) {
        News news = (News) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
        return newsMapper.toNewsDTO(news);
    }

    /**
     * Récupère toutes les actualités.
     * @return Une liste de toutes les actualités sous forme de DTO.
     */
    public List<NewsDTO> getAllNews() {
        List<News> newsList = itemRepository.findAll().stream()
                .filter(item -> item instanceof News)
                .map(item -> (News) item)
                .collect(Collectors.toList());
        return newsList.stream()
                .map(newsMapper::toNewsDTO)
                .collect(Collectors.toList());
    }
}
