package kounettechnologie.kounet.boutiqueservice.entity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import kounettechnologie.kounet.boutiqueservice.Model.Mescategories;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "Category")
public interface MescategoriesRestClient {


        @GetMapping("/gategorie/{id}")
        @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
        Mescategories findCustomerById(@PathVariable Long id);
        @GetMapping("/categorie")
        @CircuitBreaker(name = "category", fallbackMethod = "getAllCustomers")
        List<Mescategories> allCustomers();

        default Mescategories getDefaultCustomer(Long id, Exception exception){
            Mescategories customer=new Mescategories();
            customer.setId(id);
            customer.setName("Not Vailable");
            customer.setDescription("Not Vailable");

            return customer;
        }
        default List<Mescategories> getAllCustomers(Exception exception){
            return List.of();
        }
    }
