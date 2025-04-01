package kounettechnologie.kounet.blogservice.web;

import kounettechnologie.kounet.blogservice.dtos.NewsDTO;
import kounettechnologie.kounet.blogservice.dtos.NewsDTORequest;

import kounettechnologie.kounet.blogservice.exception.ResourceNotFoundException;
import kounettechnologie.kounet.blogservice.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actu/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> news = newsService.getAllNews();
        return ResponseEntity.ok(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long id)throws ResourceNotFoundException {
        NewsDTO news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTORequest newsDTORequest) {
        NewsDTO news = newsService.createNews(newsDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(news);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @RequestBody NewsDTORequest newsDTORequest)throws ResourceNotFoundException {
        NewsDTO news = newsService.updateNews(id, newsDTORequest);
        return ResponseEntity.ok(news);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) throws ResourceNotFoundException{
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}
