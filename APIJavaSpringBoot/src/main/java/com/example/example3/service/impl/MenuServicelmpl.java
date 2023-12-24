package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Menu; // Replace Order with Menu
import com.example.example3.service.MenuService; // Replace OrderService with MenuService
import com.example.example3.repository.MenuRepository; // Replace OrderRepository with MenuRepository

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServicelmpl implements MenuService { // Rename the class

    private MenuRepository menuRepository; // Rename the repository

    @Override
    public Menu createMenu(Menu menu) {
        // Set default values for the new fields
        menu.setLink("Default Link");
        menu.setParent_id(0L);
        menu.setType("Default Type");
        menu.setCreated_at(new Date());
        menu.setUpdated_at(new Date());
        menu.setCreated_by("Default Creator");
        menu.setUpdated_by("Default Updater");
        menu.setStatus("Active");
        menu.setPosition(0);

        // Set the order_date field
        // You can replace this with the actual order date

        return menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(Long menuId) {
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        return optionalMenu.orElse(null);
    }

    @Override
    public Page<Menu> getAllMenus(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        Optional<Menu> optionalMenu = menuRepository.findById(menu.getId());
        if (optionalMenu.isPresent()) {
            Menu existingMenu = optionalMenu.get();

            // Add logic to update the new fields
            existingMenu.setLink(menu.getLink());
            existingMenu.setParent_id(menu.getParent_id());
            existingMenu.setType(menu.getType());
            existingMenu.setCreated_at(new Date());
            existingMenu.setUpdated_at(new Date());
            existingMenu.setCreated_by(menu.getCreated_by());
            existingMenu.setUpdated_by(menu.getUpdated_by());
            existingMenu.setStatus(menu.getStatus());
            existingMenu.setPosition(menu.getPosition());

            return menuRepository.save(existingMenu);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
