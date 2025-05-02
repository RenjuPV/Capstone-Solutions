package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.ItemRepository;
import com.training.model.Item;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item updatedItem) {
        Item item = getItemById(id);
        item.setName(updatedItem.getName());
        item.setCategory(updatedItem.getCategory());
        item.setPurchasePrice(updatedItem.getPurchasePrice());
        item.setSellingPrice(updatedItem.getSellingPrice());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    
    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }
}