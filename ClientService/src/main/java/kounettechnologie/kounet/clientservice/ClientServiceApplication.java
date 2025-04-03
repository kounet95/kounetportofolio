package kounettechnologie.kounet.clientservice;

import kounettechnologie.kounet.clientservice.entity.Clients;
import kounettechnologie.kounet.clientservice.repos.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            // Create clients
            Clients client1 = new Clients();
            client1.setName("Oumar");
            client1.setEmail("med@gmail.com");
            clientRepository.save(client1);

            Clients client2 = new Clients();
            client2.setName("Kounet");
            client2.setEmail("kounet@gmail.com");
            clientRepository.save(client2);

            Clients client3 = new Clients();
            client3.setName("Grand");
            client3.setEmail("asmaa@gmail.com");
            clientRepository.save(client3);
        };
    }
}


