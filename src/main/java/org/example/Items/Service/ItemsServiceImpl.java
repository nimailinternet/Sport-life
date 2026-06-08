package org.example.Items.Service;

import lombok.RequiredArgsConstructor;
import org.example.Exercise.Exercise;
import org.example.Inventory.Inventory;
import org.example.Items.Exceptions.ItemsNotFoundException;
import org.example.Items.Items;
import org.example.Items.ItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {
    private  final ItemsRepository itemsRepository;

    @Override
    @Transactional(readOnly = true)
    public Set<Exercise> findExercisesByInventory(List<Inventory> inventories) {
        List<Items> items=itemsRepository.findByInventoryIn(inventories);
        if(items.isEmpty()){
            throw new ItemsNotFoundException("упражнений для такого инвентаря не найдено","result");
        }
        return items.stream().map(Items::getExercise).collect(Collectors.toSet());
    }
    @Override
    @Transactional(readOnly = true)
    public Map<Long, Set<Inventory>> findInventoryByExercise(List<Long> exercises) {
        List<Items> items=itemsRepository.findByExerciseIdIn(exercises);
        return items.stream().collect(Collectors.groupingBy(i->i.getExercise().getId(),
                Collectors.mapping(Items::getInventory, Collectors.toSet())
        ));
    }
}
