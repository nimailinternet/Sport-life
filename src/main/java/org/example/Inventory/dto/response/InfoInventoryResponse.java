package org.example.Inventory.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoInventoryResponse {
    private List<InventoryObject> response;
    @NoArgsConstructor
    @Data
    public static class InventoryObject{
        private String name;
        private String photo;
    }
}
