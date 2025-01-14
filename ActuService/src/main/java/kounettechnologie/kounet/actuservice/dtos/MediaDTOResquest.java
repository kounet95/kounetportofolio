package kounettechnologie.kounet.actuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTOResquest {


        private Long id;
        private String type;
        private String url;
        private String description;

}
