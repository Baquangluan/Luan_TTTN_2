package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Orderdetail;
import com.example.example3.repository.OrderdetailRepository;
import com.example.example3.service.OrderdetailService;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderdetailServicelmpl implements OrderdetailService {

    private OrderdetailRepository orderdetailRepository;

    @Override
    public Orderdetail createOrderdetail(Orderdetail orderdetail) {
        // Set default values for the new fields
        orderdetail.setPrice(BigDecimal.ZERO);
        orderdetail.setQty(0);
        orderdetail.setAmount(BigDecimal.ZERO);
    

        return orderdetailRepository.save(orderdetail);
    }

    @Override
    public Orderdetail getOrderdetailById(Long orderdetailId) {
        Optional<Orderdetail> optionalOrderdetail = orderdetailRepository.findById(orderdetailId);
        return optionalOrderdetail.orElse(null);
    }

    @Override
    public Page<Orderdetail> getAllOrderdetail(Pageable pageable) {
        return orderdetailRepository.findAll(pageable);
    }

    @Override
    public Orderdetail updateOrderdetail(Orderdetail orderdetail) {
        Optional<Orderdetail> optionalOrderdetail = orderdetailRepository.findById(orderdetail.getId());
        if (optionalOrderdetail.isPresent()) {
            Orderdetail existingOrderdetail = optionalOrderdetail.get();
            // Update fields based on your requirements
            existingOrderdetail.setPrice(orderdetail.getPrice());
            existingOrderdetail.setQty(orderdetail.getQty());
            existingOrderdetail.setAmount(orderdetail.getAmount());
          

            return orderdetailRepository.save(existingOrderdetail);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrderdetail(Long orderdetailId) {
        orderdetailRepository.deleteById(orderdetailId);
    }
}
