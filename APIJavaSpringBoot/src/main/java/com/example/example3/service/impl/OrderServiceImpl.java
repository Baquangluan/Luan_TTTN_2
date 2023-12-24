package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Order;
import com.example.example3.service.OrderService;
import com.example.example3.repository.OrderRepository;

import java.util.Date;
import java.util.Optional;
 // Add this import statement

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
 
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override

    public Order updateOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            existingOrder.setEmail(order.getEmail());
            existingOrder.setFullname(order.getFullname());
           
            existingOrder.setTotalMoney(order.getTotalMoney());
            existingOrder.setPhone(order.getPhone());
            existingOrder.setAddress(order.getAddress());
            existingOrder.setNote(order.getNote());
            existingOrder.setCreated_at(new Date());
            existingOrder.setUpdated_at(new Date());
            existingOrder.setCreated_by(order.getCreated_by());
            existingOrder.setUpdated_by(order.getUpdated_by());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setDescription(order.getDescription());
            existingOrder.setTitle(order.getTitle());
    
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }
    
    

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
