package kounettechnologie.kounet.boutiqueservice.mapper;




import kounettechnologie.kounet.boutiqueservice.dto.OrderDTO;
import kounettechnologie.kounet.boutiqueservice.dto.OrderItemDTO;
import kounettechnologie.kounet.boutiqueservice.entity.Order;
import kounettechnologie.kounet.boutiqueservice.entity.OrderItem;
import kounettechnologie.kounet.boutiqueservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO toOrderDTO(Order order) {
        if (order == null) {
            return null;
        }
        List<OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(this::toOrderItemDTO)
                .collect(Collectors.toList());
        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getStatus(),
                itemDTOs
        );
    }

    public Order fromOrderDTO(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setCustomerName(orderDTO.getCustomerName());
        order.setCustomerEmail(orderDTO.getCustomerEmail());
        order.setStatus(orderDTO.getStatus());
        order.setItems(orderDTO.getItems().stream()
                .map(this::fromOrderItemDTO)
                .collect(Collectors.toList()));
        return order;
    }

    private OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getId(),
                orderItem.getProduct().getId(), // ID du produit
                orderItem.getProduct().getName(), // Nom du produit
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }

    private OrderItem fromOrderItemDTO(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());

        // Mapper le produit
        Product product = new Product();
        product.setId(orderItemDTO.getProductId());
        orderItem.setProduct(product);

        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        return orderItem;
    }
}
