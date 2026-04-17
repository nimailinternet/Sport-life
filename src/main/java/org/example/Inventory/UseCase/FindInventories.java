package org.example.Inventory.UseCase;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.Inventory;
import org.example.Inventory.Service.InventoryService;
import org.example.Inventory.dto.InventoryMapper;
import org.example.Inventory.dto.response.FindInventoriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindInventories {
    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;
    public FindInventoriesResponse findInventories(int page,int size){
        Page<Inventory> inventories=inventoryService.findAllInventories(page,size);
         return inventoryMapper.toDto(inventories);
    }
}
