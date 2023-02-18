package com.example.bubble.repo;

import com.example.bubble.models.Element;
import org.springframework.data.repository.CrudRepository;

public interface ElementRepository extends CrudRepository<Element, Long> {
}
