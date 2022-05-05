package ru.mirea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.entity.ContextEntity;

@Repository
public interface ContextRepository extends JpaRepository<ContextEntity, Long> {
}
