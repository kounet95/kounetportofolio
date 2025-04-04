package kounettechnologie.kounet.blogservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTO {

    private Long id;
    private String username;
    private String email;
    private List<Long> commentIds;
    private List<Long> articleIds;

}
