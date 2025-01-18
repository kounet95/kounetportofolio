package kounettechnologie.kounet.boutiqueservice.service;


import kounettechnologie.kounet.boutiqueservice.dto.OrderItemDTO;
import kounettechnologie.kounet.boutiqueservice.entity.OrderItem;
import kounettechnologie.kounet.boutiqueservice.entity.Product;
import kounettechnologie.kounet.boutiqueservice.mapper.OrderItemMapper;
import kounettechnologie.kounet.boutiqueservice.repos.OrderItemRepository;
import kounettechnologie.kounet.boutiqueservice.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        Product product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + orderItemDTO.getProductId()));
        OrderItem orderItem = orderItemMapper.fromOrderItemDTO(orderItemDTO, product);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toOrderItemDTO(savedOrderItem);
    }

    @Override
    public OrderItemDTO getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
        return orderItemMapper.toOrderItemDTO(orderItem);
    }

    @Override
    public List<OrderItemDTO> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toOrderItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO updateOrderItem(Long id, OrderItemDTO orderItemDTO) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));

        Product product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + orderItemDTO.getProductId()));

        existingOrderItem.setProduct(product);
        existingOrderItem.setQuantity(orderItemDTO.getQuantity());
        existingOrderItem.setPrice(orderItemDTO.getPrice());

        OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
        return orderItemMapper.toOrderItemDTO(updatedOrderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new RuntimeException("OrderItem not found with id: " + id);
        }
        orderItemRepository.deleteById(id);
    }
}
