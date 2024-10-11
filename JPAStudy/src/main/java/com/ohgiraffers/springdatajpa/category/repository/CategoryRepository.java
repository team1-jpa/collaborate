package com.ohgiraffers.springdatajpa.category.repository;

import com.ohgiraffers.springdatajpa.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c.category_code, c.category_name, c.ref_category_code" +
                    "FROM tbl_category_c" +
                    "ORDER BY c.category_code ASC",
                nativeQuery = true )
    public List<Category> findAllCategory();
}
