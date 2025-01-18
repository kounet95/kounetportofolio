package kounettechnologie.kounet.boutiqueservice.mapper;


import kounettechnologie.kounet.boutiqueservice.dto.OrderItemDTO;
import kounettechnologie.kounet.boutiqueservice.entity.OrderItem;
import kounettechnologie.kounet.boutiqueservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getId(),
                orderItem.getProduct().getId(),
                orderItem.getProduct().getName(),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

    public OrderItem fromOrderItemDTO(OrderItemDTO orderItemDTO, Product product) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        return orderItem;
    }
}
