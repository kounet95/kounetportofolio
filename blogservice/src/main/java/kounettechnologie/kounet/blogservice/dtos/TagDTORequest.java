package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTORequest {
        private Long id;
        private String name;

}