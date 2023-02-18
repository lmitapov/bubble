package com.example.bubble.repo;

import com.example.bubble.models.Bubble;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BubbleRepository extends CrudRepository<Bubble, Long> {
    Optional<Bubble> findAllById(Long id);
}
