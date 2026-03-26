package org.example.Inventory.Service;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.Exceptions.InventoryNotFoundException;
import org.example.Inventory.Inventory;
import org.example.Inventory.InventoryRepository;
import org.example.Inventory.dto.response.InfoInventoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Validated
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findInventorys(List<String> names) {
        List<Inventory> inventories=new ArrayList<>();
        for(String item:names){
            inventories.add(inventoryRepository.findByName(item).orElseThrow(()->new InventoryNotFoundException("xcxcxc")));
        }
        return inventories;
    }

    @Override
    public List<String> findInventorysNames(Set<Inventory> inventories) {
        List<String> names=new ArrayList<>();
        for(Inventory inventory:inventories){
            names.add(inventory.getName());
        }
        return names;
    }

    @Override
    public List<InfoInventoryResponse.InventoryObject> infoInventory() {
        List<InfoInventoryResponse.InventoryObject> response=new ArrayList<>();
        List<Inventory> inventories=inventoryRepository.findAll();
        for(Inventory inventory:inventories){
            InfoInventoryResponse.InventoryObject inventoryObject=new InfoInventoryResponse.InventoryObject();
            inventoryObject.setName(inventory.getName());
            inventoryObject.setPhoto(inventory.getPhoto());
            response.add(inventoryObject);
        }
        return response;
    }
}
