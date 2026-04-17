package org.example.Inventory.Service;

import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface InventoryService {
    List<Inventory> findInventoriesByNames(List<String> names);
    Map<Exercise,List<String>> getInventoriesNames(Map<Exercise,Set<Inventory>> inventories);

    Page<Inventory> findAllInventories(int page ,int size);
}
