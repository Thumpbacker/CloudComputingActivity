package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.models.ProductEntity;

@Component
public interface ProductRepositoryInterface extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findOrderByProductNameContainingIgnoreCase(String searchTerm);
}
