package kounettechnologie.kounet.actuservice.mappers;

import kounettechnologie.kounet.actuservice.dtos.NewsDTO;
import kounettechnologie.kounet.actuservice.dtos.NewsDTOResquest;
import kounettechnologie.kounet.actuservice.entity.News;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Convertit un NewsDTORequest en entité News.
     */
    public News fromNewsDTORequest(NewsDTOResquest newsDTORequest) {
        return modelMapper.map(newsDTORequest, News.class);
    }

    /**
     * Convertit une entité News en NewsDTORequest.
     */
    public NewsDTOResquest toNewsDTORequest(News news) {
        return modelMapper.map(news, NewsDTOResquest.class);
    }

    /**
     * Convertit une entité News en NewsDTO.
     */
    public NewsDTO toNewsDTO(News news) {
        return modelMapper.map(news, NewsDTO.class);
    }

    /**
     * Convertit un NewsDTO en entité News.
     */
    public News fromNewsDTO(NewsDTO newsDTO) {
        return modelMapper.map(newsDTO, News.class);
    }
}
