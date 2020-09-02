package com.muet.sw.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muet.sw.pos.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
