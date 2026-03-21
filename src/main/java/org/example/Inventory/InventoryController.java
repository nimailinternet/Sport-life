package org.example.Inventory;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.UseCase.InfoInventory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InfoInventory infoInventory;
    @GetMapping("/info")
    public ResponseEntity<?> infoInventory(){
        return ResponseEntity.ok(infoInventory.infoInventory());
    }
}
