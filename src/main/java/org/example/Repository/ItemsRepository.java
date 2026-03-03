package org.example.Repository;

import org.example.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
}
