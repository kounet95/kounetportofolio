package kounettechnologie.kounet.blogservice.repos;

import kounettechnologie.kounet.blogservice.dtos.UserDTO;
import kounettechnologie.kounet.blogservice.dtos.UserDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ClientService", url = "http://localhost:8082/api/clients")
public interface UserClient {
    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id);

    @PostMapping
    UserDTO createUser(@RequestBody UserDTORequest userDTORequest);

    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTORequest userDTORequest);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id);
}

