package com.n11.repository;

import com.n11.model.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepository extends CrudRepository<Content, Long> {
}
