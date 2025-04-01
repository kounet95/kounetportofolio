package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTORequest {
    private Long id;
    private String name;
    private String location;
    private Date date;
    private List<String> mediaUrls;
    private List<Long> tagIds;

}