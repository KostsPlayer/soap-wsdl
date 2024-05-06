package com.example.webservicesoap.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.webservicesoap.model.Category;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}