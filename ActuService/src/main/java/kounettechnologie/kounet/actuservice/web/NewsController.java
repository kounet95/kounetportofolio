package kounettechnologie.kounet.actuservice.web;

import kounettechnologie.kounet.actuservice.dtos.NewsDTO;
import kounettechnologie.kounet.actuservice.dtos.NewsDTOResquest;
import kounettechnologie.kounet.actuservice.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTOResquest newsDTORequest) {
        NewsDTO createdNews = newsService.createNews(newsDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @RequestBody NewsDTOResquest newsDTORequest) {
        NewsDTO updatedNews = newsService.updateNews(id, newsDTORequest);
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long id) {
        NewsDTO news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> newsList = newsService.getAllNews();
        return ResponseEntity.ok(newsList);
    }
}
