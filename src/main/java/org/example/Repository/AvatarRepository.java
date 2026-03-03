package org.example.Repository;

import org.example.Entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Long> {
}
