package kounettechnologie.kounet.clientservice.service;

import kounettechnologie.kounet.clientservice.dto.ClientDTO;
import kounettechnologie.kounet.clientservice.entity.Clients;
import kounettechnologie.kounet.clientservice.repos.ClientRepository;

import kounettechnologie.kounet.clientservice.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientDTO createClient(ClientDTO clientDTO) {
        Clients client = clientMapper.fromClientDTO(clientDTO);
        Clients savedClient = clientRepository.save(client);
        return clientMapper.toClientDTO(savedClient);
    }

    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Clients existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        existingClient.setName(clientDTO.getName());
        existingClient.setEmail(clientDTO.getEmail());
        existingClient.setPhoneNumber(clientDTO.getPhoneNumber());
        existingClient.setAddress(clientDTO.getAddress());
        Clients updatedClient = clientRepository.save(existingClient);
        return clientMapper.toClientDTO(updatedClient);
    }

    public void deleteClient(Long id) {
        Clients client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        clientRepository.delete(client);
    }

    public ClientDTO getClientById(Long id) {
        Clients client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return clientMapper.toClientDTO(client);
    }

    public List<ClientDTO> getAllClients() {
        List<Clients> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toClientDTO)
                .collect(Collectors.toList());
    }
}
