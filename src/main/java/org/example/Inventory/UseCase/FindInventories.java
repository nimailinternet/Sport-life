package org.example.Inventory.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.Inventory;
import org.example.Inventory.Service.InventoryService;
import org.example.Inventory.dto.InventoryMapper;
import org.example.Inventory.dto.response.FindInventoriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindInventories {
    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;

    public FindInventoriesResponse findInventories(){
        List<Inventory> inventories=inventoryService.findAllInventories();
         return inventoryMapper.toDto(inventories);
    }
}
