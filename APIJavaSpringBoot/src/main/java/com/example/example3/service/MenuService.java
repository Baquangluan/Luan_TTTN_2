package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Menu;


public interface MenuService {  
    
    public Menu createMenu(Menu menu); 
    public Menu getMenuById(Long menuId);  
    public Page<Menu> getAllMenus(Pageable pageable);
    public Menu updateMenu(Menu menu); 
    public void deleteMenu(Long menuId); 
}
