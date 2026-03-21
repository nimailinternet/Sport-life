package org.example.Inventory.Service;

import org.example.Inventory.Inventory;
import org.example.Inventory.dto.response.InfoInventoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

@Service
@Validated
public interface InventoryService {
    List<Inventory> FindInventory(List<String> names);
    List<String> findInventoryName(Set<Inventory> inventories);

    List<InfoInventoryResponse.InventoryObject> infoInventory();
}
