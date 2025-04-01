package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTOResquest {

        private Long id;
        private String description;
        private String type;
        private String url;

}
