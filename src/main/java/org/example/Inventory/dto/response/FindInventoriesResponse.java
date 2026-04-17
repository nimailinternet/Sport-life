package org.example.Inventory.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindInventoriesResponse {
    private List<InventoryObject> inventories;
    private int size;
    private int page;
    private long totalPage;
    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    public static class InventoryObject{
        private String name;
        private String photo;
    }
}
