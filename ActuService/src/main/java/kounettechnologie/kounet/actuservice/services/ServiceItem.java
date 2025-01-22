package kounettechnologie.kounet.actuservice.services;

import kounettechnologie.kounet.actuservice.dtos.ItemDTO;
import kounettechnologie.kounet.actuservice.entity.Item;
import kounettechnologie.kounet.actuservice.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceItem {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Sauvegarde un item générique.
     * @param item L'objet `Item` à sauvegarder.
     * @return L'item sauvegardé.
     */
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Supprime un item par ID.
     * @param id L'identifiant de l'item à supprimer.
     */
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        itemRepository.delete(item);
    }

    /**
     * Récupère un item par ID.
     * @param id L'identifiant de l'item à récupérer.
     * @return L'item correspondant.
     */
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    /**
     * Récupère tous les items.
     * @return Une liste de tous les items.
     */
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convertit un `Item` en `ItemDTO`.
     * @param item L'objet `Item` à convertir.
     * @return Un DTO représentant l'item.
     */
    private ItemDTO convertToDTO(Item item) {
        // Conversion simple ; à personnaliser selon vos besoins
        return ItemDTO.builder()
                .id(item.getId())
                .type(item.getClass().getSimpleName())
                .name(item.getName())
                .createdAt(item.getCreatedAt())
                .build();
    }
}
