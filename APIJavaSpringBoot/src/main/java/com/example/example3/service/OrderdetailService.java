package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Orderdetail; 

public interface OrderdetailService {  
    
    public Orderdetail createOrderdetail(Orderdetail orderdetail); 
    public Orderdetail getOrderdetailById(Long orderdetailId);  
    public Page<Orderdetail> getAllOrderdetail(Pageable pageable);
    public Orderdetail updateOrderdetail(Orderdetail orderdetail); 
    public void deleteOrderdetail(Long orderdetailId); 
}
