package org.example.Inventory.Service;

import org.example.Inventory.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface InventoryService {
    List<Inventory> findInventoriesByIds(List<Long> ids);
    Map<Long,List<String>> getInventoriesIds(Map<Long,Set<Inventory>> inventories);

    Page<Inventory> findAllInventories(int page ,int size);
}
