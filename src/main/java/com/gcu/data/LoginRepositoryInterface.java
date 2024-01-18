package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.models.LoginEntity;

@Component
public interface LoginRepositoryInterface extends CrudRepository<LoginEntity, Long> {
    List<LoginEntity> findOrderByProductNameContainingIgnoreCase(String searchTerm);
}
