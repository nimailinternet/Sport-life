package org.example.Inventory.UseCase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Inventory.Service.InventoryService;
import org.example.Inventory.dto.response.InfoInventoryResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoInventory {
    private final InventoryService inventoryService;
    @Transactional
    public InfoInventoryResponse infoInventory(){
        InfoInventoryResponse response=new InfoInventoryResponse();
         response.setResponse(inventoryService.infoInventory());
         return response;
    }
}
