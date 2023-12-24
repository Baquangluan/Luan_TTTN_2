package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.example3.entity.Orderdetail;
import com.example.example3.service.OrderdetailService;

@RestController
@AllArgsConstructor
@RequestMapping("api/orderdetail")  // Thay đổi đường dẫn thành "api/orderdetails"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class OrderdetailController {

    private OrderdetailService orderdetailService;

    // Create Orderdetail REST API
    @PostMapping
    public ResponseEntity<Orderdetail> createOrderdetail(@RequestBody Orderdetail orderdetail) {
        Orderdetail savedOrderdetail = orderdetailService.createOrderdetail(orderdetail);
        return new ResponseEntity<>(savedOrderdetail, HttpStatus.CREATED);
    }

    // Get Orderdetail by id REST API
    // http://localhost:8080/api/orderdetails/1
    @GetMapping("{id}")
    public ResponseEntity<Orderdetail> getOrderdetailById(@PathVariable("id") Long orderdetailId) {
        Orderdetail orderdetail = orderdetailService.getOrderdetailById(orderdetailId);
        if (orderdetail != null) {
            return new ResponseEntity<>(orderdetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Orderdetails REST API
    // http://localhost:8080/api/orderdetails
    @GetMapping
    public ResponseEntity<Page<Orderdetail>> getAllOrderdetails(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Orderdetail> orderdetails = orderdetailService.getAllOrderdetail(pageable);
        return new ResponseEntity<>(orderdetails, HttpStatus.OK);
    }

    // Update Orderdetail REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/orderdetails/1
    public ResponseEntity<Orderdetail> updateOrderdetail(@PathVariable("id") Long orderdetailId,
            @RequestBody Orderdetail orderdetail) {
        orderdetail.setId(orderdetailId);
        Orderdetail updatedOrderdetail = orderdetailService.updateOrderdetail(orderdetail);
        return new ResponseEntity<>(updatedOrderdetail, HttpStatus.OK);
    }

    // Delete Orderdetail REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderdetail(@PathVariable("id") Long orderdetailId) {
        orderdetailService.deleteOrderdetail(orderdetailId);
        return new ResponseEntity<>("Orderdetail successfully deleted!", HttpStatus.OK);
    }
}
