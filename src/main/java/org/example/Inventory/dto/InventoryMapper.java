package org.example.Inventory.dto;

import org.example.Favourites.dto.response.FindFavouritesResponse;
import org.example.Inventory.Inventory;
import org.example.Inventory.dto.response.FindInventoriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryMapper {
    public FindInventoriesResponse toDto(Page<Inventory> inventories){
        FindInventoriesResponse findInventoriesResponse=new FindInventoriesResponse();
        findInventoriesResponse.setSize(inventories.getSize());
        findInventoriesResponse.setTotalPage(inventories.getTotalPages());
        findInventoriesResponse.setPage(inventories.getNumber());
        List<FindInventoriesResponse.InventoryObject> response=inventories.stream().map(i->{
            return new FindInventoriesResponse.InventoryObject(i.getName(),i.getPhoto());
        }).toList();
        findInventoriesResponse.setInventories(response);
        return findInventoriesResponse;
    }
}
