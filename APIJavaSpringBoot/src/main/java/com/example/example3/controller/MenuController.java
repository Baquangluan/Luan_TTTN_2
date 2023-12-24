package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.example3.entity.Menu;  // Change Post to Menu
import com.example.example3.service.MenuService;  // Change PostService to MenuService

@RestController
@AllArgsConstructor
@RequestMapping("api/menus")  // Change the path to "api/menus"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class MenuController {

    private MenuService menuService;  // Change PostService to MenuService

    // Create Menu REST API
    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {  // Change Post to Menu
        Menu savedMenu = menuService.createMenu(menu);  // Change PostService to MenuService
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }

    // Get Menu by id REST API
    // http://localhost:8080/api/menus/1  // Change the path
    @GetMapping("{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable("id") Long menuId) {  // Change postId to menuId
        Menu menu = menuService.getMenuById(menuId);  // Change getPostById to getMenuById
        if (menu != null) {
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Menus REST API
    // http://localhost:8080/api/menus  // Change the path
    @GetMapping
    public ResponseEntity<Page<Menu>> getAllMenus(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Menu> menus = menuService.getAllMenus(pageable);  // Change Posts to menus
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    // Update Menu REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/menus/1  // Change the path
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") Long menuId,
            @RequestBody Menu menu) {  // Change Post to Menu
        menu.setId(menuId);  // Change postId to menuId
        Menu updatedMenu = menuService.updateMenu(menu);  // Change PostService to MenuService
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    // Delete Menu REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long menuId) {  // Change postId to menuId
        menuService.deleteMenu(menuId);  // Change deletePost to deleteMenu
        return new ResponseEntity<>("Menu successfully deleted!", HttpStatus.OK);
    }
}
