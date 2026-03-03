package org.example.Repository;

import org.example.Entity.Males;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MalesRepository extends JpaRepository<Males,Long> {
}
