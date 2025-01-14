package kounettechnologie.kounet.clientservice.mapper;



import kounettechnologie.kounet.clientservice.dto.ClientDTO;
import kounettechnologie.kounet.clientservice.entity.Clients;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Clients fromClientDTO(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Clients.class);
    }

    public ClientDTO toClientDTO(Clients client) {
        return modelMapper.map(client, ClientDTO.class);
    }
}

