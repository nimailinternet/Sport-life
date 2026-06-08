package org.example.Inventory.Service;

import lombok.RequiredArgsConstructor;
import org.example.Inventory.Exceptions.InventoryNotFoundException;
import org.example.Inventory.Inventory;
import org.example.Inventory.InventoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> findInventoriesByIds(List<Long> ids) {
        List<Inventory> inventories=inventoryRepository.findByIdIn(ids);
        if(inventories.isEmpty()){
            throw new InventoryNotFoundException("","result");
        }
        return inventories;
    }

    @Override
    public Map<Long, List<String>> getInventoriesIds(Map<Long, Set<Inventory>> inventories) {
        return inventories.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,m->m.getValue().stream().map(i->{
            return i.getId().toString();
        }).toList()));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Inventory> findAllInventories(int page,int size) {
        Pageable pageable=PageRequest.of(page,size);
        return inventoryRepository.findAll(pageable);
    }
}
