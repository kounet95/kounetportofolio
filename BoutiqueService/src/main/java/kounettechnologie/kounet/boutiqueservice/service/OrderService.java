package kounettechnologie.kounet.boutiqueservice.service;

import kounettechnologie.kounet.boutiqueservice.dto.OrderDTO;
import kounettechnologie.kounet.boutiqueservice.entity.Order;

import kounettechnologie.kounet.boutiqueservice.mapper.OrderMapper;
import kounettechnologie.kounet.boutiqueservice.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.fromOrderDTO(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderDTO(savedOrder);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return orderMapper.toOrderDTO(order);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        existingOrder.setCustomerName(orderDTO.getCustomerName());
        existingOrder.setCustomerEmail(orderDTO.getCustomerEmail());
        existingOrder.setStatus(orderDTO.getStatus());
        existingOrder.setItems(orderMapper.fromOrderDTO(orderDTO).getItems());
        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toOrderDTO(updatedOrder);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
}
