package kounettechnologie.kounet.clientservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTORequest {
    private Long id;
    private String username;
    private String email;
}
