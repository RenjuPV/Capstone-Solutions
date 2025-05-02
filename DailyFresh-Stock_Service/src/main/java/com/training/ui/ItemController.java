package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Item;
import com.training.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/getItemById/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/updateItem/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully.";
    }
    
    @GetMapping("/category/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category) {
        return itemService.getItemsByCategory(category);
    }
}