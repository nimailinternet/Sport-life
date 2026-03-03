package org.example.Repository;

import org.example.Entity.Male;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleRepository extends JpaRepository<Male,Long> {
}
